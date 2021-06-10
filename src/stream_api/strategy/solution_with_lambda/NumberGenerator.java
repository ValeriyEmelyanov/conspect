package stream_api.strategy.solution_with_lambda;

import stream_api.strategy.solution_with_pattern.GenerationStrategy;

public class NumberGenerator {
    private final stream_api.strategy.solution_with_pattern.GenerationStrategy strategy;

    public NumberGenerator(GenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public String generate() {
        return strategy.generate();
    }
}
