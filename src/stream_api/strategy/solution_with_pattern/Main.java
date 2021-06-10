package stream_api.strategy.solution_with_pattern;

public class Main {
    public static void main(String[] args) {
        // an example of using UUIDGeneratingStrategy
        final NumberGenerator uuidGenerator = new NumberGenerator(new UUIDGenerationStrategy());
        System.out.println(uuidGenerator.generate());

        // an example of using FormattedRandomGenerationStrategy
        final NumberGenerator randomGenerator = new NumberGenerator(new RandomNumberGenerationStrategy());
        System.out.println(randomGenerator.generate());
    }
}
