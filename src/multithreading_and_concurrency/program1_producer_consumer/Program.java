package multithreading_and_concurrency.program1_producer_consumer;

/** "Производитель-Потребитель" ("Producer-Consumer"):
 * пока производитель не произвел продукт, потребитель не может его купить.
 * Пусть производитель должен произвести 5 товаров, соответственно потребитель должен их все купить.
 * Но при этом одновременно на складе может находиться не более 3 товаров.
 * */
public class Program {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    // Магазин
    static class Store {
        private int product = 0;

        private synchronized void get() {
            while (product < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }

        public synchronized void put() {
            while (product >= 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify();
        }
    }

    // Производитель
    static class Producer implements Runnable {
        Store store;

        public Producer(Store store) {
            this.store = store;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                store.put();
            }
        }
    }

    // Потребитель
    static class Consumer implements Runnable {
        Store store;

        public Consumer(Store store) {
            this.store = store;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                store.get();
            }
        }
    }
}
