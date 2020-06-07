package patterns.creational.factories_staticfactory_computers;

/**
 * The static factory has one static method which creates objects of the hierarchy.
 * The method takes a required type as a string or enum argument
 * and returns a corresponding subclass instance through the base class.
 * Possible implementation features:
 *  - the method newInstance of ComputerStaticFactory takes an enum type to restrict possible values;
 *  - the method newInstance throws an exception if an unsuitable type is passed instead of returning null;
 *  - move the method newInstance directly to the base of the hierarchy: Computer class;
 *  - a factory can have multiple methods that produce instances of different classes
 *  or an instance of a default class.
 */
public class FactoryClient {
    public static void main(String[] args) {
        Computer pc = ComputerStaticFactory.newInstance("PC");
        System.out.println(pc instanceof PC); // prints "true"

        Computer laptop = ComputerStaticFactory.newInstance("Laptop");
        System.out.println(laptop instanceof Laptop); // prints "true"
    }
}
