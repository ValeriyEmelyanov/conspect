package multithreading_and_concurrency.program_blocking_queue1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQApp {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new ArrayBlockingQueue<>(1, true);
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
