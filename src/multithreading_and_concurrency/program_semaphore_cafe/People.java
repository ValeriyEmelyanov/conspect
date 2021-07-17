package multithreading_and_concurrency.program_semaphore_cafe;

public class People implements Runnable {
    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();

            System.out.printf("%d Гости с потока %s пришли в кафе и ищут столик\n",
                    System.currentTimeMillis(), threadName);
            Main.tables.acquire();

            System.out.printf("%d Гости с потока %s сели за столик и позвали официанта\n",
                    System.currentTimeMillis(), threadName);
            Main.waiter.acquire();

            System.out.printf("Официант подошел к гостям с потока %s\n", threadName);
            Thread.sleep(2000);
            System.out.printf("Официант принял заказ у гостей с потока %s\n", threadName);
            Main.waiter.release();

            Thread.sleep(4000);
            Main.waiter.acquire();

            System.out.printf("Официант принес заказ гостям с потока %s\n", threadName);
            Main.waiter.release();

            Thread.sleep(4000);
            System.out.printf("%d Гости с потока %s покушали и ушли\n", System.currentTimeMillis(), threadName);
            Main.tables.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
