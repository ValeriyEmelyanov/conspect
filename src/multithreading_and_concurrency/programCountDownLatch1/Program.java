package multithreading_and_concurrency.programCountDownLatch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Waiting for a Pool of Threads to Complete
 */
public class Program {
    public static void main(String[] args) throws InterruptedException {
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new Worker(outputScraper, countDownLatch)))
                .limit(5)
                .collect(toList());
        workers.forEach(Thread::start);
        countDownLatch.await();
        outputScraper.add("Latch released");

        outputScraper.forEach(line -> System.out.println(line));
    }
}
