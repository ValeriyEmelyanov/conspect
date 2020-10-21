package patterns.creational.factories_abstractfactory_devices;

import patterns.creational.factories_abstractfactory_devices.devices.Keyboard;
import patterns.creational.factories_abstractfactory_devices.devices.Mouse;
import patterns.creational.factories_abstractfactory_devices.devices.Touchpad;
import patterns.creational.factories_abstractfactory_devices.factories.DeviceFactory;
import patterns.creational.factories_abstractfactory_devices.factories.EnDeviceFactory;
import patterns.creational.factories_abstractfactory_devices.factories.RuDeviceFactory;

public class Main {
    public static void main(String[] args) {
        DeviceFactory factory = getDeviceFactoryByCountryCode("RU");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        Touchpad touchpad = factory.getTouchpad();

        mouse.click();
        keyboard.println();
        touchpad.track(10, 20);
    }

    public static DeviceFactory getDeviceFactoryByCountryCode(String code){
        switch (code) {
            case "EN":
                return new EnDeviceFactory();
            case "RU":
                return new RuDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code: " + code);
        }
    }
}
