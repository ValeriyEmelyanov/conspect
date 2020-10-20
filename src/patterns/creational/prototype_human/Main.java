package patterns.creational.prototype_human;

public class Main {
    public static void main(String[] args) {
        Human original = new Human(21, "Bob");
        System.out.println("Original: " + original);

        Human copy1 = (Human) original.copy();
        System.out.println("Copy 1: " + copy1);

        HumanFactory factory = new HumanFactory(original);
        Human copy2 = factory.makeCopy();
        System.out.println("Copy 2: " + copy2);
    }
}
