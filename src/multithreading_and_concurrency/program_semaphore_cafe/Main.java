package multithreading_and_concurrency.program_semaphore_cafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Эмулируем работу кафе с 3-мя столиками и одним официантом.
 */
public class Main {
    static final Semaphore tables = new Semaphore(3);
    static final Semaphore waiter = new Semaphore(1);

    public static boolean isAvailableHours = true;

    public static synchronized boolean isOpen() {
        return isAvailableHours;
    }

    public static synchronized  void close() {
        isAvailableHours = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable cafe = () -> {
            for (int i = 0; isOpen(); i++) {
                try {
                    new Thread(new People(), String.valueOf(i)).start();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread cafeThread = new Thread(cafe, "Cafe");
        cafeThread.start();
        TimeUnit.SECONDS.sleep(6);
        close();
    }
}
