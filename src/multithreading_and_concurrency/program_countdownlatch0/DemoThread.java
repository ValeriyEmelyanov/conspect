package multithreading_and_concurrency.program_countdownlatch0;

import java.util.concurrent.CountDownLatch;

public class DemoThread extends Thread {
    private final CountDownLatch latch;

    public DemoThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            runUnsafe();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }

    private void runUnsafe() throws InterruptedException {
        init();

        latch.countDown();
        latch.await();

        System.out.println(getName() + " entered main phase");
        Thread.sleep((long) (Math.random() * 10_000L));
    }

    private void init() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 10_000L));
        System.out.println(getName() + " finished initialization");
    }
}
