package multithreading_and_concurrency.programSemaphore1;

import java.util.concurrent.Semaphore;

/**
 * В примере несколько всадников с лошадьми должны пройти контроль перед скачками.
 * Количество контроллеров меньше количества всадников,
 * поэтому некоторые всадники будут дожидаться, пока не освободиться один из контроллеров.
 *
 * Общий ресурс CONTROL_PLACES, символизирующий контролеров и используемый всеми потоками,
 * выделен оператором synchronized.
 * С помощью семафора осуществляется контроль доступа только одному потоку.
 */
public class SemaphoreExample {
    private static final int COUNT_CONTROL_PLACES = 5;
    private static final int COUNT_RIDERS         = 7;
    // Флаги мест контроля
    private static  boolean[] CONTROL_PLACES = null;
    // Семафор
    private static Semaphore SEMAPHORE = null;

    public static class Rider implements Runnable {
        private int riderNum;

        public Rider(int riderNum) {
            this.riderNum = riderNum;
        }

        @Override
        public void run() {
            System.out.printf("Всадник %d подошел к зоне контроля\n", riderNum);
            try {
                // Запрос разрешения
                SEMAPHORE.acquire();
                System.out.printf("\tвсадник %d проверяет наличие свободного контролера\n", riderNum);
                int controlNum = -1;
                // Ищем свободное место и переходим к контролеру
                synchronized (CONTROL_PLACES) {
                    for (int i = 0; i < COUNT_CONTROL_PLACES; i++) {
                        if (CONTROL_PLACES[i]) {
                            // Занимаем место
                            CONTROL_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf("\t\tвсадник %d подошел к контролеру %d.\n", riderNum, controlNum);
                            break;
                        }
                    }
                }
                //Время проверки лошади и всадника
                Thread.sleep((int) (Math.random() * 10 + 1) * 1000);
                // Освобождение места контроля
                synchronized (CONTROL_PLACES) {
                    CONTROL_PLACES[controlNum] = true;
                }
                // Освобождение ресурса
                SEMAPHORE.release();
                System.out.printf("Всадник %d завершил проверку\n", riderNum);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CONTROL_PLACES = new boolean[COUNT_CONTROL_PLACES];
        // Флаги мест контроля: true - свободно, false - занято
        for (int i = 0; i < CONTROL_PLACES.length; i++) {
            CONTROL_PLACES[i] = true;
        }

        SEMAPHORE = new Semaphore(CONTROL_PLACES.length, true);

        for (int i = 0; i < COUNT_RIDERS; i++) {
            new Thread(new Rider(i)).start();
            Thread.sleep(400);
        }
    }
}
