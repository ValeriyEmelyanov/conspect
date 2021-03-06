package multithreading_and_concurrency.creatoin_livetest;

public class SimpleThread extends Thread {
    private static LogHelper log = LogHelper.getLogger(RunnableVsThreadLiveTest.class);
    private String message;

    public SimpleThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        log.info(message);
    }
}
