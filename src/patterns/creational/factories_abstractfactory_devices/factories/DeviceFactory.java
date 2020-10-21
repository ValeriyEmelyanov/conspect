package patterns.creational.factories_abstractfactory_devices.factories;

import patterns.creational.factories_abstractfactory_devices.devices.Keyboard;
import patterns.creational.factories_abstractfactory_devices.devices.Mouse;
import patterns.creational.factories_abstractfactory_devices.devices.Touchpad;

public interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
