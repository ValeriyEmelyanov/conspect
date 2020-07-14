package stream_api.separated_by_space;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(list.stream()
        .map(Object::toString)
        .collect(Collectors.joining(" ")));
    }
}
