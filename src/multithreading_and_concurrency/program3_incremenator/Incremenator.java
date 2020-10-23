package multithreading_and_concurrency.program3_incremenator;

public class Incremenator extends Thread {
    private volatile boolean isIncrement = true;

    public void changeAction() {
        isIncrement = !isIncrement;
    }

    @Override
    public void run() {
        do {
            if (!interrupted()) {
                if (isIncrement) {
                    Program.value ++;
                } else {
                    Program.value--;
                }
                System.out.print(Program.value + " ");
            } else {
                return;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}
