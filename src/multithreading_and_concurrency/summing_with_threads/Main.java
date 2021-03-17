package multithreading_and_concurrency.summing_with_threads;

import java.util.Scanner;

/**
 * The following code is calculating the general sum of two inclusive integer ranges in parallel.
 * Sample Input:
 * 1 5
 * 2 4
 * Sample Output:
 * 24
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        int from1 = scanner.nextInt(); // left limit of the first range
        int to1Incl = scanner.nextInt();   // right limit of the first range

        int from2 = scanner.nextInt(); // left limit of the second range
        int to2Incl = scanner.nextInt();   // right limit of the second range

        RangeSummator summator1 = new RangeSummator(from1, to1Incl); // first summator
        RangeSummator summator2 = new RangeSummator(from2, to2Incl); // second summator

        summator1.start();
        summator2.start();

        summator1.join();
        summator2.join();

        long partialSum1 = summator1.getResult();
        long partialSum2 = summator2.getResult();

        long sum = partialSum1 + partialSum2;

        System.out.println(sum);
    }
}
