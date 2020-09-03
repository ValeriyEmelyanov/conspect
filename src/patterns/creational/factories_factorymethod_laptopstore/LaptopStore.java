package patterns.creational.factories_factorymethod_laptopstore;

public class LaptopStore extends LaptopFactory {
    @Override
    Laptop createLaptop(String type) {
        String name = type + " Laptop";
        switch (type) {
            case "13 inch":
                return new Laptop13(name);
            case "15 inch":
                return new Laptop15(name);
            case "17 inch":
                return new Laptop17(name);
            default:
                return null;
        }
    }
}
