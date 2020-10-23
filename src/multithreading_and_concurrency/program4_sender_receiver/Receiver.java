package multithreading_and_concurrency.program4_sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String receiveMessage = load.receive(); !"End".equals(receiveMessage); receiveMessage = load.receive()) {
            System.out.println(receiveMessage);
        }
        // mimic heavy server-side processing
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
