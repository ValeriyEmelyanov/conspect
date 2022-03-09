package multithreading_and_concurrency.program_lock4_readwrite;

import java.util.concurrent.locks.Lock;

public class WriteWorker implements Runnable {
    private final Lock writeLock;
    private final Data data;

    public WriteWorker(Lock writeLock, Data data) {
        this.writeLock = writeLock;
        this.data = data;
    }

    @Override
    public void run() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "|Write lock acquired");
            Thread.sleep(3000);
            data.setValue("changed value");
            System.out.println(Thread.currentThread().getName() + "|Writing data: changed value");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
