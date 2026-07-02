package kr.magicbox.waiting.application.port.out;

import kr.magicbox.waiting.domain.vo.ReleaseId;
import reactor.core.publisher.Mono;

public interface VegasMetricRepositoryPort {

    Mono<Void> record(ReleaseId releaseId, int batchSize, long waitingCount, long queueDepth);
}
