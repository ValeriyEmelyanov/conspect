package patterns.creational.factories_factorymethod_watches.factory;

import patterns.creational.factories_factorymethod_watches.product.DigitalWatch;
import patterns.creational.factories_factorymethod_watches.product.Watch;

public class DigitalWatchFactory implements WatchFactory {
    @Override
    public Watch create() {
        return new DigitalWatch();
    }
}
