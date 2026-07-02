package kr.magicbox.waiting.adapter.out.persistence.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("vegas_metric")
@NoArgsConstructor
public class VegasMetricEntity {

    @Id
    private Long id;
    @Column("release_id")
    private Long releaseId;
    @Column("recorded_at")
    private Instant recordedAt;
    @Column("batch_size")
    private int batchSize;
    @Column("waiting_count")
    private long waitingCount;
    @Column("queue_depth")
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
