package multithreading_and_concurrency.program_lock4_readwrite;

import java.util.concurrent.locks.Lock;

public class ReadWorker implements Runnable {
    private final Lock readLock;
    private final Data data;

    public ReadWorker(Lock readLock, Data data) {
        this.readLock = readLock;
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "|Read lock acquired");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "|Reading data: " + data.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }
    }
}
