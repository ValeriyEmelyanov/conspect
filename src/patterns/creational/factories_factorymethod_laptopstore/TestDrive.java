package patterns.creational.factories_factorymethod_laptopstore;

/**
 * Factory method pattern defines an interface for creating an object
 * but leaves it to the subclasses to decide which class to instantiate.
 * So basically, Factory Method allows the class to delegate instantiation to subclasses.
 * The goal of any factory is to protect customers
 * from the details of creating copies of classes or class hierarchy.
 * Factory Method is a special case of the Template Method pattern,
 * the variable step of which is responsible for creating the desired type of object.
 *
 * The Factory Method pattern has the following components:
 *  - Creator;
 *  - Concrete Creator;
 *  - Product;
 *  - Concrete Product.
 *
 *  These 4 components carry out functions:
 *  1. Creator declares an abstract or virtual method of creating a product.
 *     It uses the factory method in its implementation.
 *  2. ConcreteCreator implements a factory method that returns ConcreteProduct.
 *  3. Product defines the interface of products created by the factory method.
 *  4. ConcreteProduct determines the specific type of products.
 *
 *  Factory Method comes in handy in situations when you need to:
 *  - have a complicated process for constructing the objects;
 *  - reduce the time to add another product;
 *  - replace one product with another.
 */
public class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        LaptopStore laptopStore = new LaptopStore();

        Laptop laptop13 = laptopStore.orderLaptop("13 inch");
        Laptop laptop15 = laptopStore.orderLaptop("15 inch");
        Laptop laptop17 = laptopStore.orderLaptop("17 inch");

        System.out.println("Available laptops in the store:");
        System.out.println(laptop13);
        System.out.println(laptop15);
        System.out.println(laptop17);
    }
}
