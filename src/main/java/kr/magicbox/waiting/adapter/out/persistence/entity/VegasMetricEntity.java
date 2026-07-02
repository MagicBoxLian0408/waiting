package kr.magicbox.waiting.adapter.out.persistence.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("waiting.vegas_metric")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VegasMetricEntity {

    @Id
    private Long id;
    private Long releaseId;
    private Instant recordedAt;
    private int batchSize;
    private long waitingCount;
    private long queueDepth;
}
