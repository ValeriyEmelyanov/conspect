package multithreading_and_concurrency.program_semaphore0;

import java.util.concurrent.Semaphore;

/**
 * Потоки пытаются одновременно получить доступ к одному методу (ресурсу) someMethod().
 * Количество потоков, которые могут одновременно работать с методом (ресурсом),
 * задается переменной availableNumber.
 */
public class SemaphoreSample {
    public static void main(String[] args) {
        final int availableNumber = 1;
        Semaphore semaphore = new Semaphore(availableNumber);
        Runnable runnable = () -> {
            try {
                System.out.printf("Поток: %s запрашивает доступ к someMethod.\n",
                        Thread.currentThread().getName());
                semaphore.acquire();
                someMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void someMethod() {
        try {
            System.out.printf("Somemethod: работает поток: %s\n", Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
