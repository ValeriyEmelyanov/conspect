package algorithms.greedy_algorithm.bag;

public class Item implements Comparable {
    private String name;
    private int weight;
    private int cost;

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Object o) {
        return this.cost > ((Item) o).getCost() ? -1 : 1;
    }
}
