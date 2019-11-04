package multithreading_and_concurrency.creatoinLiveTest;

import multithreading_and_concurrency.creatoinLiveTest.SimpleCallable;
import multithreading_and_concurrency.creatoinLiveTest.SimpleRunnable;
import multithreading_and_concurrency.creatoinLiveTest.SimpleThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/** Комплексный пример создания потоков:
 * - наследование от класса Thread
 * - реализация интерфейса Runnable
 * - реализация интерфейса Callable
 * - работа с Executor
 * */
public class RunnableVsThreadLiveTest {
    private static LogHelper log = LogHelper.getLogger(RunnableVsThreadLiveTest.class);
    private static ExecutorService executorService;

    public static void main(String[] args) throws Exception {
        givenAThread_whenRunIt_thenResult();
        givenARunnable_whenRunIt_thenResult();
        givenACallable_whenRunIt_thenResult();

        executorService = Executors.newCachedThreadPool();

        givenAThread_whenSubmitToES_thenResult();
        givenARunnable_whenSubmitToES_thenResult();
        givenARunnableLambda_whenSubmitToES_thenResult();
        givenACallable_whenSubmitToES_thenResult();
        givenACallableAsLambda_whenSubmitToES_thenResult();

        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    // Extends Thread
    private static void givenAThread_whenRunIt_thenResult() throws Exception {
        Thread thread = new SimpleThread("SimpleThread executed using Thread");
        thread.start();
        thread.join();
    }

    // Implements Runnable
    private static void givenARunnable_whenRunIt_thenResult() throws Exception {
        Thread thread = new Thread(new SimpleRunnable("SimpleRunnable executed using Thread"));
        thread.start();
        thread.join();
    }

    // Implements Callable
    private static void givenACallable_whenRunIt_thenResult() throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new SimpleCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.join();
        log.info("Result from callable: {}", futureTask.get());
    }

    // Executor - Thread
    private static void givenAThread_whenSubmitToES_thenResult() throws Exception {
        executorService.submit(new SimpleThread("SimpleThread executed using ExecutorService"));
    }

    // Executor - Runnable
    private static void givenARunnable_whenSubmitToES_thenResult() throws Exception {
        executorService.submit(new SimpleRunnable("SimpleRunnable executed using ExecutorService"));
    }

    // Executor - Runnable as Lambda
    private static void givenARunnableLambda_whenSubmitToES_thenResult() throws Exception {
        executorService.submit(() -> log.info("Lambda runnable executed using ExecutorService"));
    }

    // Executor - Callable
    private static void givenACallable_whenSubmitToES_thenResult() throws Exception {
        Future<Integer> future = executorService.submit(new SimpleCallable());
        log.info("Result from callable: {}", future.get());
    }

    // Executor - Callable as Lambda
    private static void givenACallableAsLambda_whenSubmitToES_thenResult() throws Exception {
        Future<Integer> future = executorService.submit(() -> (int) (Math.random() * 10));
        log.info("Result from callable: {}", future.get());
    }
}
