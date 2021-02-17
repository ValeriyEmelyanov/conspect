package algorithms.greedy_algorithm.bag;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final int maxWeight;
    private List<Item> items;
    private int weight;
    private int cost;

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
        weight = 0;
        cost = 0;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public void addItem(Item item) {
        items.add(item);
        weight += item.getWeight();
        cost += item.getCost();
    }
}
