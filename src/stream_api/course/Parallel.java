package stream_api.course;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Parallel {
    public static void main(String[] args) {
        // Creating

        // to invoke the parallelStream() method of a collection instead of stream()
        List<String> languages = List.of("java", "scala", "kotlin", "C#");
        List<String> jvmLanguages = languages.parallelStream()
                .filter(lang -> !Objects.equals(lang, "C#"))
                .collect(Collectors.toList());
        System.out.println(jvmLanguages);

        // to transform an existing stream into a parallel stream using the parallel() method
        long sum = LongStream.rangeClosed(1, 1_000_000)
                .parallel()
                .sum();
        System.out.println(sum);

        // There are two additional methods for working with parallel streams:
        //  isParallel() returns true if the stream is parallel and false otherwise;
        //  sequential() returns an equivalent sequential stream.

        // The order of elements
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .parallel()
                .filter(x -> x % 2 == 0)
                .forEachOrdered((n) -> System.out.print(n + " "));
    }
}
