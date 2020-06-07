package patterns.creational.factories_simplefactory_computers;

public class ComputerFactory {

    public Computer newInstance(String type) {
        switch (type.toUpperCase()) {
            case "COMPUTER":
                return new Computer();
            case "PC":
                return new PC();
            case "LAPTOP":
                return new Laptop();
            default:
                return null;
        }
    }

}
