package kr.magicbox.waiting.adapter.out.kafka;

import tools.jackson.databind.ObjectMapper;
import kr.magicbox.waiting.adapter.out.kafka.event.PurchaseTokenIssuedKafkaEvent;
import kr.magicbox.waiting.application.port.out.PurchaseTokenEventPublishPort;
import kr.magicbox.waiting.domain.vo.ReleaseId;
import kr.magicbox.waiting.domain.vo.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class PurchaseTokenEventKafkaAdapter implements PurchaseTokenEventPublishPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> publish(ReleaseId releaseId, UserId userId, String purchaseToken) {
        PurchaseTokenIssuedKafkaEvent event = new PurchaseTokenIssuedKafkaEvent(
                releaseId.value(), userId.value(), purchaseToken
        );
        return Mono.fromCallable(() -> objectMapper.writeValueAsString(event))
                .flatMap(json -> Mono.fromRunnable(() -> kafkaTemplate.send("sse.purchase-token-issued", String.valueOf(userId.value()), json)))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnError(e -> log.error("purchase token 이벤트 발행 실패 releaseId={} userId={}",
                        releaseId.value(), userId.value(), e))
                .onErrorResume(e -> Mono.empty())
                .then();
    }
}
