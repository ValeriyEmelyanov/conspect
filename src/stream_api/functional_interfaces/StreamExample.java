package stream_api.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // Predicate
        Stream<Integer> evenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(x -> x % 2 == 0);
        evenNumbers.forEach(x -> System.out.print(x + " "));
        System.out.println("\n");

        // Consumer
        // peek вернет Stream с изначальными элементами: такими, какими они ему пришли
        List<String> names = Stream.of("Elena", "John", "Alex", "Jim", "Sara")
                .peek(x -> System.out.println("Hello " + x + "!!!"))
                .collect(Collectors.toList());
        System.out.println();

        // Supplier
        List<String> names2 = Arrays.asList("Elena", "John", "Alex", "Jim", "Sara");
        Stream
                .generate(() -> {
                    int index = (int) (Math.random() * names2.size());
                    return names2.get(index);
                })
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        List<String> list = Stream.of(32, 43, 74, 95, 101)
                .map(x -> "<" + String.valueOf(x) + ">")
                .collect(Collectors.toList());
        list.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // UnaryOperator
        Stream
                .iterate(9, x -> x * x)
                .limit(4)
                .forEach(System.out::println);
        System.out.println();

        Stream
                .iterate(9, x -> x + 1)
                .limit(4)
                .forEach(System.out::println);

    }
}
