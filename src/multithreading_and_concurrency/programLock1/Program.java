package multithreading_and_concurrency.programLock1;

import java.util.concurrent.locks.ReentrantLock;

public class Program {
    public static void main(String[] args) {
        CommonResource res = new CommonResource();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread(new CountThread(res, lock));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
