package stream_api.read_and_concat_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PositiveNumbersConcater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);
        //ArrayList<Integer> result = concatPositiveNumbersWithFuction(list1, list2);
        //ArrayList<Integer> result = concatPositiveNumbersWithPredicat(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Integer> concatPositiveNumbers(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return Stream
                .concat(list1.stream().filter(n -> n >= 0), list2.stream().filter(n -> n >= 0))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Integer> concatPositiveNumbersWithFuction(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Function<ArrayList<Integer>, Stream<Integer>> positive = list -> list.stream().filter(n -> n >= 0);
        return Stream
                .concat(positive.apply(list1), positive.apply(list2))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Integer> concatPositiveNumbersWithPredicat(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Predicate<Integer> positive = n -> n >= 0;
        return Stream
                .concat(list1.stream().filter(positive), list2.stream().filter(positive))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
