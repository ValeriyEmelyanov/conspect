package stream_api.course;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreationPrimitive {
    public static void main(String[] args) {

        // from elements

        IntStream ints = IntStream.of(1, 2, 3, 4, 5);
        LongStream longs = LongStream.of(1, 2, 3);
        DoubleStream doubls = DoubleStream.of(1., 18.1);

        // from an array of primitives

        IntStream numbers = Arrays.stream(new int[]{1, 2, 3});

        // range() and rangeClosed() for IntStream and LongStream

        IntStream intRange = IntStream.range(1, 10);
        LongStream longsRange = LongStream.rangeClosed(1, 10);

        // from a string

        IntStream chars = "abrakadabra".chars();

        // generate, iterate, concat

        DoubleStream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // transforming

        IntStream.of(1, 2, 3, 4)
                .asDoubleStream()
                .forEach(System.out::println);

        Stream<Integer> streamOfNumbers = IntStream.range(1, 10).boxed();

        List<Integer> nums = List.of(1, 5, 9);
        int sum = nums.stream().mapToInt(i -> i).sum();
    }
}
