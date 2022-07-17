package multithreading_and_concurrency.program_cyclicbarrier1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private final int carNumber;
    private final CyclicBarrier ferryBarrier;

    public Car(int carNumber, CyclicBarrier ferryBarrier) {
        this.carNumber = carNumber;
        this.ferryBarrier = ferryBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.printf("К переправе подъехал автомобиль %d\n", carNumber);
            ferryBarrier.await();
            System.out.printf("Автомобиль %d продолжил движение\n", carNumber);
        } catch (BrokenBarrierException | InterruptedException ignored) {
        }
    }
}
