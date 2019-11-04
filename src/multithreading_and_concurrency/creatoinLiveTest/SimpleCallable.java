package multithreading_and_concurrency.creatoinLiveTest;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return (int) (Math.random() * 10);
    }
}
