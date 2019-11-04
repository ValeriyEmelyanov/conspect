package stream_api.find_single_duplicate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Задан массив (или ArrayList, как вам больше нравится) целых чисел,
 * в котором содержатся элементы Integer от 1 до 100.
 * В этом массиве есть один и только один продублированный элемент.
 * Как его найти?
 */
public class FindSingleDuplicate {
    private static void findDuplicate(List<Integer> elements) {
        // находим сумму всех уникальных элементов списка
        int distinctSum = elements.stream().distinct().mapToInt(e -> e).sum();
        // находим сумму всех элементов списка
        int totalSum = elements.stream().mapToInt(e -> e).sum();
        int result = totalSum - distinctSum;
        System.out.println("Элемент, который повторяется : " + result);
    }

    public static void main(String[] args) {
        //создаем список последовательных элементов на промежутке [1..101]
        List<Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        //устанавливаем элементу с индексом 53 значение 23
        elements.set(53, 23);
        findDuplicate(elements);
    }
}
