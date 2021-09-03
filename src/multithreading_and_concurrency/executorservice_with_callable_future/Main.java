package multithreading_and_concurrency.executorservice_with_callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main начал работу");
        int threadsNumber = 15;
        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);

        Callable<String> callable = () -> {
            System.out.printf("%s начал работу\n", Thread.currentThread().getName());
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        };

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < threadsNumber; i++) {
            futures.add(executorService.submit(callable));
        }

        System.out.println("Main запустил все callable");

        for (Future<String> future : futures) {
            System.out.printf("Результат из потока %s\n", future.get());
        }

        executorService.shutdown();
        System.out.println("Main подошел к концу");
    }
}
