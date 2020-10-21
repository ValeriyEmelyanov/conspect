package patterns.creational.factories_abstractfactory_devices.factories;

import patterns.creational.factories_abstractfactory_devices.devices.EnKeyboard;
import patterns.creational.factories_abstractfactory_devices.devices.EnMouse;
import patterns.creational.factories_abstractfactory_devices.devices.EnTouchpad;
import patterns.creational.factories_abstractfactory_devices.devices.Keyboard;
import patterns.creational.factories_abstractfactory_devices.devices.Mouse;
import patterns.creational.factories_abstractfactory_devices.devices.Touchpad;

public class EnDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
