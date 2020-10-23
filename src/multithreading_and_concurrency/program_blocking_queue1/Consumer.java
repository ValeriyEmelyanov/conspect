package multithreading_and_concurrency.program_blocking_queue1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        try {
            String message = null;
            while (!((message = drop.take()).equals("DONE"))) {
                System.out.println(message);
            }
        } catch (InterruptedException e) {
            System.out.println("Last one out, turn out the lights!");
        }
    }
}
