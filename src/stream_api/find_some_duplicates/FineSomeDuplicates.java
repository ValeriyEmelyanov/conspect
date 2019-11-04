package stream_api.find_some_duplicates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Lан лист целых чисел от 1 до 100. В нём есть дубликаты (больше одного).
 * Как найти элементы, которые встречаются больше одного раза (найти сам элемент и указать, сколько раз он встречается)?
 */
public class FineSomeDuplicates {
    private static void findDuplicates(List<Integer> elements) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //заполняем Map map значениями по принципу:
        // ключ – значение элемента, значение – сколько раз он встречается
        elements.forEach(e-> map.put(e, map.getOrDefault(e, 0) + 1));
        //из duplicates убираем все элементы, которые встретились не более 1 раза,
        //и сохраняем результат в список (для удобства обработки на следующем шаге)
        List<Map.Entry<Integer, Integer>> result = map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toList());
        result.forEach(e -> System.out.println(
                String.format("Элемент %d  встречается %d раз", e.getKey(), e.getValue())));
    }

    public static void main(String[] args) {
        List<Integer> elements = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        elements.set(97, 23);
        elements.set(27, 51);
        elements.set(99, 23);
        findDuplicates(elements);
    }
}
