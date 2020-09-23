package patterns.creational.factories_simplefactory_clocks;

public class SandClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}
