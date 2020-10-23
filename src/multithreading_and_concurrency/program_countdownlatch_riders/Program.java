package multithreading_and_concurrency.program_countdownlatch_riders;

import java.util.concurrent.CountDownLatch;

/**
 * Несколько всадников должны подъехать к барьеру.
 * Как только все всадники выстроятся перед барьером, будут даны команды «На старт», «Внимание», «Марш».
 * После этого барьер опустится и начнутся скачки.
 * Объект синхронизации CountDownLatch выполняет роль счетчика количества всадников и команд.
 */
public class Program {
    private static final int RIDERS_COUNT = 5;
    private static CountDownLatch LATCH;
    private static final int trackLength = 3000;

    public static class Rider implements Runnable {
        private int riderNumber;
        private int riderSpeedd;

        public Rider(int riderNumber, int riderSpeedd) {
            this.riderNumber = riderNumber;
            this.riderSpeedd = riderSpeedd;
        }

        @Override
        public void run() {

            try {
                System.out.printf("Всадник %d вышел на старт\n", riderNumber);
                LATCH.countDown();
                // Метод await блокирует поток до тех пор, пока счетчик CountDownLatch не обнулится.
                LATCH.await();
                // Ожидание, пока всадник не преодолеет трассу
                Thread.sleep(trackLength / riderSpeedd * 10);
                System.out.printf("Всадник %d финишировал\n", riderNumber);
            } catch (InterruptedException e) {}
        }
    }

    public static Rider createRider(final int number) {
        return new Rider(number, (int) (Math.random() * 10 + 5));
    }

    public static void main(String[] args) throws InterruptedException {
        LATCH = new CountDownLatch(RIDERS_COUNT);

        // Создание потоков-всадников
        for (int i = 1; i <= RIDERS_COUNT; i++) {
            new Thread(createRider(i)).start();
            Thread.sleep(500);
        }

        // Проверка наличия всех всадников на старте
        while (LATCH.getCount() > 3) {
            Thread.sleep(100);
        }

        Thread.sleep(500);
        System.out.println("На старт!");
        LATCH.countDown();
        System.out.println("Внимание!");
        LATCH.countDown();
        System.out.println("Марш!");
        LATCH.countDown();

        // Счетчик обнулен, и все ожидающие этого события потоки разблокированы
    }
}
