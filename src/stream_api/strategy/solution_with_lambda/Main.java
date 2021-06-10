package stream_api.strategy.solution_with_lambda;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // an example of using UUIDGeneratingStrategy
        final NumberGenerator uuidGenerator = new NumberGenerator(
                () -> UUID.randomUUID().toString());
        System.out.println(uuidGenerator.generate());

        // an example of using FormattedRandomGenerationStrategy
        final NumberGenerator randomGenerator = new NumberGenerator(
                () -> String.format("%06d", (int) (Math.random() * 100001)));
        System.out.println(randomGenerator.generate());
    }
}
