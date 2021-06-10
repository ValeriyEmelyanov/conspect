package stream_api.strategy.solution_with_pattern;

public class RandomNumberGenerationStrategy implements GenerationStrategy {
    @Override
    public String generate() {
        return String.format("%06d", (int) (Math.random() * 100001));
    }
}
