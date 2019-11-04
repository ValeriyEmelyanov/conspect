package multithreading_and_concurrency.stopping;

import java.util.concurrent.atomic.AtomicBoolean;

public class ControlSubThread implements Runnable {
    private AtomicBoolean running = new AtomicBoolean(false);
    private AtomicBoolean stopped = new AtomicBoolean(true);
    private Thread worker;

    @Override
    public void run() {
        running.set(true);
        stopped.set(false);
        while (running.get()) {
            try {
                System.out.println("tick");
                Thread.sleep(100);
                System.out.println("tack");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            }
        }
        stopped.set(true);
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    public void interript() {
        running.set(false);
        worker.interrupt();
    }

    public boolean isRunning() {
        return running.get();
    }

    public boolean isStopped() {
        return stopped.get();
    }
}
