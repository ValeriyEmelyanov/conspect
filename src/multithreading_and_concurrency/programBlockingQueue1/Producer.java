package multithreading_and_concurrency.programBlockingQueue1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> drop;
    private List<String> messages = Arrays.asList(
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "Wouldn't you eat ivy too?"
    );

    public Producer(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        try {
            for (String s : messages) {
                drop.put(s);
            }
            drop.put("DONE");
        } catch (InterruptedException e) {
            System.out.println("Interapted! " + "Last one out, turn out the lights!");
        }
    }
}
