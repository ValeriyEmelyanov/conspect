package patterns.creational.factories_factorymethod_watches;

import patterns.creational.factories_factorymethod_watches.factory.DigitalWatchFactory;
import patterns.creational.factories_factorymethod_watches.factory.ModernWatchFactory;
import patterns.creational.factories_factorymethod_watches.factory.WatchFactory;
import patterns.creational.factories_factorymethod_watches.product.Watch;

public class Main {
    public static void main(String[] args) {
        WatchFactory factory = getFactoryByName("modern");
        Watch watch = factory.create();
        watch.showTime();
    }

    private static WatchFactory getFactoryByName(String type) {
        if ("digital".equals(type)) {
            return new DigitalWatchFactory();
        } else if ("modern".equals(type)) {
            return new ModernWatchFactory();
        } else {
            throw new RuntimeException("Wrong type: " + type);
        }
    }
}
