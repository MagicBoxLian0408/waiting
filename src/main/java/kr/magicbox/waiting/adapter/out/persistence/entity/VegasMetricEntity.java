package kr.magicbox.waiting.adapter.out.persistence.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("vegas_metric")
@NoArgsConstructor
public class VegasMetricEntity {

    @Id
    private Long id;
    private Long releaseId;
    private Instant recordedAt;
    private int batchSize;
    private long waitingCount;
    private long queueDepth;

    @Builder
    public VegasMetricEntity(Long releaseId, Instant recordedAt, int batchSize, long waitingCount, long queueDepth) {
        this.releaseId = releaseId;
        this.recordedAt = recordedAt;
        this.batchSize = batchSize;
        this.waitingCount = waitingCount;
        this.queueDepth = queueDepth;
    }
}
