package multithreading_and_concurrency.programLock2;

public class CountThread implements Runnable {
    SharedObject num;

    public CountThread(SharedObject num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                num.perform();
                System.out.printf("%s %d\n", Thread.currentThread().getName(), num.getCount());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
