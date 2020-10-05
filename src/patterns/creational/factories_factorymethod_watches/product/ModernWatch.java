package patterns.creational.factories_factorymethod_watches.product;

import java.time.LocalTime;

public class ModernWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(LocalTime.now());
    }
}
