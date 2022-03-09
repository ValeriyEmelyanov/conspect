package multithreading_and_concurrency.program_lock4_readwrite;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private final Data data = new Data("default value");
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();
        example.start();
    }

    private void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new ReadWorker(readWriteLock.readLock(), data));
        }
        executorService.execute(new WriteWorker(readWriteLock.writeLock(), data));
        executorService.shutdown();
    }
}
