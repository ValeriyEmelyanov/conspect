package patterns.creational.factories_abstractfactory_devices.devices;

public class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int n = (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
        System.out.println("Moved " + n);
    }
}
