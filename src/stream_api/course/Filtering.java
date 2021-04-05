package stream_api.course;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        List<Integer> filtered = primeNumbers.stream()
                .filter(n -> n >= 11 && n <= 23)
                .collect(Collectors.toList());
        // or
        Predicate<Integer> between11and23 = n -> n >= 11 && n <= 23;
        List<Integer> filtered2 = primeNumbers.stream()
                .filter(between11and23)
                .collect(Collectors.toList());
    }
}
