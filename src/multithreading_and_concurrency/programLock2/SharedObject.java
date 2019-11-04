package multithreading_and_concurrency.programLock2;

import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
    private ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void perform() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    //public void performTryLock() throws InterruptedException {
    //    boolean isLockAquired = lock.tryLock(1, TimeUnit.SECONDS);
    //    if (isLockAquired) {
    //        try {
    //            count++;
    //        } finally {
    //            lock.unlock();
    //        }
    //    }
    //}


    public int getCount() {
        return count;
    }
}
