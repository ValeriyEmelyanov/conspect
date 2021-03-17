package multithreading_and_concurrency.summing_with_threads;

/**
 * Class RangeSummator extends Thread and overrides the method run.
 * It sums the range passed to the constructor (left and right limits as integers).
 * The class has a getter getResult() that returns the calculated sum
 * or 0 if the thread has not calculated the sum yet.
 */
public class RangeSummator extends Thread {
    int from;
    int toIncl;

    private long result = 0;

    public RangeSummator(int from, int toIncl) {
        this.from = from;
        this.toIncl = toIncl;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = from; i <= toIncl; i++) {
            sum += i;
        }
        result = sum;
    }

    public long getResult() {
        return result;
    }
}
