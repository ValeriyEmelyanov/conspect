package stream_api.strategy.solution_with_pattern;

import java.util.UUID;

public class UUIDGenerationStrategy  implements GenerationStrategy {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
