package patterns.creational.factories_simplefactory_clocks;

public class MechanicalClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}
