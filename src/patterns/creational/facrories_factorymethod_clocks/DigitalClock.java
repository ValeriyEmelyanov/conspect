package patterns.creational.facrories_factorymethod_clocks;

public class DigitalClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}
