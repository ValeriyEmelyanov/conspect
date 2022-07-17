package multithreading_and_concurrency.program_cyclicbarrier1;

import java.util.concurrent.CyclicBarrier;

public class FerryBoat implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Загрузка автомобилей");
            Thread.sleep(500);
            System.out.println("Паром переправил автомобили");
        } catch (InterruptedException ignored) {
        }
    }
}
