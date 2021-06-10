package stream_api.strategy.solution_with_pattern;

public class NumberGenerator {
    private final GenerationStrategy strategy;

    public NumberGenerator(GenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public String generate() {
        return strategy.generate();
    }
}
