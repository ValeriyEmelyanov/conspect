package patterns.creational.factories_simplefactory_clocks;

public class DigitalClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}
