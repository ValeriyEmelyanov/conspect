package patterns.creational.facrories_factorymethod_burgerstore;

public class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger();
            case "American":
                return new AmericanBurger();
            case "Russian":
                return new RussianBurger();
            default:
                return null;
        }
    }
}
