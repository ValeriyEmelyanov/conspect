package patterns.creational.factories_factorymethod_watches.factory;

import patterns.creational.factories_factorymethod_watches.product.ModernWatch;
import patterns.creational.factories_factorymethod_watches.product.Watch;

public class ModernWatchFactory implements WatchFactory {
    @Override
    public Watch create() {
        return new ModernWatch();
    }
}
