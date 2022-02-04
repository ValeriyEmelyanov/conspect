package multithreading_and_concurrency.program_countdownlatch0;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new DemoThread(latch).start();
        }
    }
}
