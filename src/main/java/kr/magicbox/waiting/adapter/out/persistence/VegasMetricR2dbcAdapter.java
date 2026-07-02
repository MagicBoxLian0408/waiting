package kr.magicbox.waiting.adapter.out.persistence;

import kr.magicbox.waiting.adapter.out.persistence.entity.VegasMetricEntity;
import kr.magicbox.waiting.application.port.out.VegasMetricRepositoryPort;
import kr.magicbox.waiting.domain.vo.ReleaseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class VegasMetricR2dbcAdapter implements VegasMetricRepositoryPort {

    private final VegasMetricR2dbcRepository vegasMetricR2dbcRepository;

    @Override
    public Mono<Void> record(ReleaseId releaseId, int batchSize, long waitingCount, long queueDepth) {
        VegasMetricEntity entity = new VegasMetricEntity(
                releaseId.value(), Instant.now(), batchSize, waitingCount, queueDepth);
        return vegasMetricR2dbcRepository.save(entity).then();
    }
}
