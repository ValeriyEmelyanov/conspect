package multithreading_and_concurrency.creatoinLiveTest;

public class SimpleRunnable implements Runnable {
    private static LogHelper log = LogHelper.getLogger(RunnableVsThreadLiveTest.class);
    private String message;

    public SimpleRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        log.info(message);
    }
}
