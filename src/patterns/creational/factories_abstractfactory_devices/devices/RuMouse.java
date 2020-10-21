package patterns.creational.factories_abstractfactory_devices.devices;

public class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dblClick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скролинг вверх");
        } else if (direction < 0) {
            System.out.println("Скролинг вниз");
        } else {
            System.out.println("Нет скроллинга");
        }
    }
}
