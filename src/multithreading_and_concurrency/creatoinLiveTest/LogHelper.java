package multithreading_and_concurrency.creatoinLiveTest;

import java.util.concurrent.Future;

public class LogHelper {
    private Class cl;

    private LogHelper(Class cl) {
        this.cl = cl;
    }

    public static LogHelper getLogger(Class cl) {
        return new LogHelper(cl);
    }

    public void info(String message) {
        System.out.printf("[%s] INFFO %s - %s%n",
                Thread.currentThread().getName(),
                cl.getName(),
                message);
    }

    public void info(String message, Object obj ) {
        System.out.printf("[%s] INFFO %s - %s %s%n",
                Thread.currentThread().getName(),
                cl.getName(),
                message,
                obj);
    }
}
