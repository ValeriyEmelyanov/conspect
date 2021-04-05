package stream_api.course;

import java.util.stream.Stream;

public class CreationInfinite {
    public static void main(String[] args) {

        // generate

        Stream<Double> randomNumbers = Stream.generate(Math::random);

        Stream<User> userStream = Stream.generate(User::new);

        // iterate

        Stream<Integer> oddNumbers = Stream.iterate(1, x -> x + 2);
        // 1  the starting value
        // x -> x + 2  the function to produce the next values

        Stream.iterate(1, x -> x < 10, x -> x + 2)
                .forEach(System.out:: println);
        // print the odd numbers that are less than 10
    }

    static class User {
        String name;
    }
}
