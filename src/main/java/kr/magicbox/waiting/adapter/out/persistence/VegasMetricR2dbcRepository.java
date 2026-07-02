package kr.magicbox.waiting.adapter.out.persistence;

import kr.magicbox.waiting.adapter.out.persistence.entity.VegasMetricEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VegasMetricR2dbcRepository extends ReactiveCrudRepository<VegasMetricEntity, Long> {
}
