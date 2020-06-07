package patterns.creational.factories_simplefactory_computers;

/**
 * The simple factory idioms differ from the static factory
 * because the method for creating objects is non-static.
 * In the client code, we should create an instance of the factory
 * and then invoke newInstance
 *
 * Unlike with the static factory,
 * it is possible to create multiple differently parameterized factories to control instantiating.
 * It is possible also to subclass the factory and override its non-static method
 * that is used to create other factories.
 */
public class FactoryClient {
    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        Computer pc = factory.newInstance("PC");
        System.out.println(pc instanceof PC); // prints "true"
    }
}
