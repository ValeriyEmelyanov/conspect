package stream_api.course;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Reduction {
    public static void main(String[] args) {

        // reduce

        List<Integer> transactions = List.of(20, 40, -60, 5);

        Optional<Integer> optionsTransSum = transactions.stream()
                .reduce((sum, transaction) -> sum + transaction);
        // At the first iteration of the reduction,
        // the sum argument equals to the first element of the stream

        Integer transSum = transactions.stream()
                .reduce(0, (sum, transaction) -> sum + transaction);
        // Another reduce implementation has one additional parameter: identity value or seed.
        // Now, the initial value of the partial result sum is 0.

        // reduce, sum, min, max, etc

        Optional<Integer> maxOfTwo = transactions.stream().reduce((t1, t2) -> t2 > t1 ? t2 : t1);

        Optional<Integer> optionalTransMax = transactions.stream().max(Integer::compareTo);

        OptionalInt optionalMax = IntStream.of(20, 40, -60, 5).max();
    }
}
