package multithreading_and_concurrency.programCountDownLatchRace;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Одна защелка освобождает все потоки одновременно, имитируя старт скачек.
 * Позднее другая защелка имитирует окончание гонки, чтобы основной поток мог вывести на экран результаты.
 */
public class Race {
    private Random rand = new Random();
    private int distance = 100 + rand.nextInt(150);
    private List<String> horses = new ArrayList<>();

    public Race(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public int getDistance() {
        return distance;
    }

    public void run() throws InterruptedException {
        final CountDownLatch start = new CountDownLatch(horses.size() + 1);
        final CountDownLatch finish = new CountDownLatch(horses.size());
        final List<String> places = Collections.synchronizedList(new ArrayList<>());

        System.out.println("And the horses are stepping up to the gate...");

        for (final String horse : horses) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(horse + " stepping up to the gate...");
                        start.countDown();
                        start.await();
                        int traveled = 0;
                        while (traveled < distance) {
                            // через 0-0,2 секунды ...
                            Thread.sleep(rand.nextInt(3) * 100);
                            // ... лошадь проходит дистанцию 0-14 пунктов
                            traveled += rand.nextInt(15);
                            System.out.println(horse + " advanced to " + traveled + "!");
                        }
                        finish.countDown();
                        System.out.println(horse + " crossed the finish!");
                        places.add(horse);
                    } catch (InterruptedException e) {
                        System.out.println("ABORTING RACE!!!");
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        while (start.getCount() > 1) {
            System.out.println("... must wait ...");
            Thread.sleep(1);
        }
        System.out.println("And... they're off!");
        start.countDown();

        finish.await();
        System.out.println("And we have our winners!");
        System.out.println(places.get(0) + " took the gold,");
        System.out.println(places.get(1) + " got the silver,");
        System.out.println(places.get(2) + " took home the bronze.");
    }
}
