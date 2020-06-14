package patterns.creational.facrories_factorymethod_clocks;

public class SandClock implements Clock {
    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}
