package multithreading_and_concurrency.programLock1;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    private CommonResource res;
    private ReentrantLock lock;

    public CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            //res.num = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d\n", Thread.currentThread().getName(), res.num);
                res.num++;
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }

    }
}
