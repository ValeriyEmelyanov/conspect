package multithreading_and_concurrency.program_cyclicbarrier1;

import java.util.concurrent.CyclicBarrier;

/**
 * В примере организуется переправа.
 * Паром может вместить только 3 автомобиля.
 * Необходимо переправить 9 автомобилей.
 * Роль парома выполняет FerryBoat,
 * объект синхронизации FerryBarrier,
 * которому в качестве второго параметра передается реализующий интерфейс Runnable класс FerryBoat.
 * Как только 3 потока достигнут барьера автоматически будет запущен FerryBoat,
 * после завершения работы которого потоки продолжают свою работу.
 */
public class CyclicBarrierExample {
    private static final int FERRYBOAT_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier ferryBarrier = new CyclicBarrier(FERRYBOAT_SIZE, new FerryBoat());

        for (int i = 1; i < 10; i++) {
            new Thread(new Car(i, ferryBarrier)).start();
            Thread.sleep(400);
        }
    }
}
