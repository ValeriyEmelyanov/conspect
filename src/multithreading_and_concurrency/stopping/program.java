package multithreading_and_concurrency.stopping;

public class program {
    public static void main(String[] args) throws Exception {
        ControlSubThread controlSubThread = new ControlSubThread();
        controlSubThread.start();
        Thread.sleep(3000);
        controlSubThread.interript();
        //controlSubThread.stop();
    }
}
