package patterns.structural_pattern.decorator_javadeveloper;

/**
 * A approach is to put the component in another object called the decorator.
 * The Decorator is a structural pattern used to add new responsibilities
 * to an object dynamically without extending functionality.
 * That lets you dynamically change the behavior of an object at runtime
 * by wrapping it in an object of a decorator class.
 *
 * Decorators are used for adding some behavior that is not part of the core functionality to all interface methods.
 * Decorator pattern perfectly suits for the following tasks:
 *  - caching the work results;
 *  - measuring the execution time of methods;
 *  - user access control.
 *
 * The decorator pattern has the following components:
 *  - Component is the interface for the objects that will get new responsibilities from the decorators;
 *  - oncrete Component defines objects which implement the Component interface
 *  and will get new responsibilities from the concrete decorators;
 *  - Decorator has reference to the Component and overridden component methods;
 *  - Concrete Decorator extends Decorator class and adds new functions,
 *  properties or state without creating new classes;
 */
public class Main {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(
                new SeniorJavaDeveloper(
                        new JavaDeveloper()));
        System.out.println(developer.makeJob());
    }
}
