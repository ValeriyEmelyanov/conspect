package algorithms.greedy_algorithm.bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Собрать в рюкзак набор товаров максимальной стоимости.
 */
public class Solution {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("гитара",7, 800));
        items.add(new Item("утюг",6, 500));
        items.add(new Item("чайник",3, 300));
        items.add(new Item("лампа",4, 500));
        items.add(new Item("телевизор",15, 2000));
        items.add(new Item("ваза",2, 450));
        items.add(new Item("миксер",1, 400));
        items.add(new Item("блендер",3, 200));

        Bag firstBag = new Bag(30);
        fillBag(firstBag, items);
        System.out.println("Вес рюкзака состовляет - " + firstBag.getWeight() +
                ", общая стоимость вещей в рюкзаке - " + firstBag.getCost());
        System.out.println(
                firstBag.getItems().stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(",")));

        Bag secondBag = new Bag(30);
        effectiveFillBag(secondBag, items);
        System.out.println("Вес рюкзака состовляет - " + secondBag.getWeight() +
                ", общая стоимость вещей в рюкзаке - " + secondBag.getCost());
        System.out.println(
                secondBag.getItems().stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(",")));
    }

    private static void fillBag(Bag bag, List<Item> items) {
        Collections.sort(items);
        for (Item item : items) {
            if (bag.getMaxWeight() >= bag.getWeight() + item.getWeight()) {
                bag.addItem(item);
            }
        }
    }

    private static void effectiveFillBag(Bag bag, List<Item> items) {
        Map<Double, Item> sortedByRatio = new TreeMap<>(Collections.reverseOrder());
        for (Item item : items) {
            sortedByRatio.put((double) item.getCost() / item.getWeight(), item);
        }

        for (Map.Entry<Double, Item> entry : sortedByRatio.entrySet()) {
            if (bag.getMaxWeight() >= bag.getWeight() + entry.getValue().getWeight()) {
                bag.addItem(entry.getValue());
            }
        }

    }
}
