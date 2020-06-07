package patterns.creational.factories_staticfactory_computers;

public class ComputerStaticFactory {

    public static Computer newInstance(String type) {
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
