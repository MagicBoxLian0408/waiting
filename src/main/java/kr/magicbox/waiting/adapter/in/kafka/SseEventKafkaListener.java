package kr.magicbox.waiting.adapter.in.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SseEventKafkaListener {

    @KafkaListener(topics = "sse.connected", groupId = "waiting-service")
    public void handleConnected(ConsumerRecord<String, String> record) {
        log.debug("SSE 연결 이벤트 수신 userId={}", record.key());
    }

    @KafkaListener(topics = "sse.disconnected", groupId = "waiting-service")
    public void handleDisconnected(ConsumerRecord<String, String> record) {
        log.debug("SSE 끊김 이벤트 수신 userId={}", record.key());
    }
}
