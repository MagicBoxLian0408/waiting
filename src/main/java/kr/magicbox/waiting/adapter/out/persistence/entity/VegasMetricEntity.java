package kr.magicbox.waiting.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("waiting.vegas_metric")
public class VegasMetricEntity {

    @Id
    private Long id;
    private Long releaseId;
    private Instant recordedAt;
    private int batchSize;
    private long waitingCount;
    private long queueDepth;

    public VegasMetricEntity(Long releaseId, Instant recordedAt, int batchSize, long waitingCount, long queueDepth) {
        this.releaseId = releaseId;
        this.recordedAt = recordedAt;
        this.batchSize = batchSize;
        this.waitingCount = waitingCount;
        this.queueDepth = queueDepth;
    }
}
