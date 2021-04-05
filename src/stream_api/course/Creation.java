package stream_api.course;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Creation {
    public static void main(String[] args) {

        // from a collection

        List<Integer> numberList = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Stream<Integer> numberStream = numberList.stream();

        Set<String> concepts = Set.of("functions", "lazy", "immutability");
        Stream<String> conceptsStream = concepts.stream();

        // from an array

        Double[] doubles = {1.01, 1d, 0.99, 1.02, 1d, 0.99};
        Stream<Double> doubleStream = Arrays.stream(doubles);

        // directly from some values

        Stream<String> names = Stream.of("Ann", "Bob", "Jain");

        // concatenating other streams together

        Stream<String> stream1 = Stream.of("some", "values", "...");
        Stream<String> stream2 = Stream.of("value1", "value2", "value3");
        Stream<String> resultStream = Stream.concat(stream1, stream2);

        // empty streams

        Stream<Integer> empty1 = Stream.of();
        Stream<Integer> empty2 = Stream.empty();

        // Intermediate operations:
        // filter
        // limit
        // skip
        // distinct
        // sorted
        // peek
        // map

        // Terminal operations
        // count
        // max / min (returns Optional)
        // reduce
        // indFirst / findAny (returns Optional)
        // anyMatch, allMatch, noneMatch
        // forEach
        // collect
        // toArray
    }
}
