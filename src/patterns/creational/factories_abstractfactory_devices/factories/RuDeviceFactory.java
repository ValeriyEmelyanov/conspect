package patterns.creational.factories_abstractfactory_devices.factories;

import patterns.creational.factories_abstractfactory_devices.devices.Keyboard;
import patterns.creational.factories_abstractfactory_devices.devices.Mouse;
import patterns.creational.factories_abstractfactory_devices.devices.RuKeyboard;
import patterns.creational.factories_abstractfactory_devices.devices.RuMouse;
import patterns.creational.factories_abstractfactory_devices.devices.RuTouchpad;
import patterns.creational.factories_abstractfactory_devices.devices.Touchpad;

public class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}
