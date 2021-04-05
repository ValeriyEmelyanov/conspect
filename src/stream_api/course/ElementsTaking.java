package stream_api.course;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElementsTaking {
    public static void main(String[] args) {

        // takeWhile

        List<Integer> numbers = Stream.of(3, 5, 1, 2, 0, 4, 5)
                .takeWhile(n -> n > 0)
                .collect(Collectors.toList());
        System.out.println(numbers); // [3, 5, 1, 2]

        // dropWhile

        List<Integer> numbers2 = Stream.of(3, 5, 1, 2, 0, 4, 5)
                .dropWhile(n -> n > 0)
                .collect(Collectors.toList());
        System.out.println(numbers2); // [0, 4, 5]

    }
}
