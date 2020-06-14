package patterns.creational.facrories_factorymethod_burgerstore;

public class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        BurgerStore burgerStore = new BurgerStore();
        burgerStore.orderBurger("Chinese");
        burgerStore.orderBurger("American");
        burgerStore.orderBurger("Russian");
    }
}
