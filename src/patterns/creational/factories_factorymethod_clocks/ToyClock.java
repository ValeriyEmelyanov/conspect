package patterns.creational.factories_factorymethod_clocks;

public class ToyClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...tick...");
    }
}
