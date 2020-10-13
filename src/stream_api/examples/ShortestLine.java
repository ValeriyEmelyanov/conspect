package stream_api.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ShortestLine {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("first line", "second line", "short", "this is longest line");
        String shortest = list.stream()
                .min(Comparator.comparing(String::length))
                .get();
        System.out.println(shortest);
    }
}
