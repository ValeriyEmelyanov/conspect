package multithreading_and_concurrency.program2_chiken_or_egg;

public class EggVoice extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {}
            System.out.println("яйцо!");
        }
    }
}
