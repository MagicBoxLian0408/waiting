package kr.magicbox.waiting.adapter.out.kafka.event;

public record PurchaseTokenIssuedKafkaEvent(
        Long releaseId,
        Long userId,
        String purchaseToken
) {}