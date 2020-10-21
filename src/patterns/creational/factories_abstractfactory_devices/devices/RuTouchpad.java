package patterns.creational.factories_abstractfactory_devices.devices;

public class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int n = (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
        System.out.println("Передвинулись на " + n);
    }
}
