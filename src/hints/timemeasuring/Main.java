package hints.timemeasuring;

public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        someFunction();

        long endTime = System.nanoTime() - startTime;
        System.out.println(endTime);

        long oneSec = 1_000_000_000;
        if (endTime >= oneSec) {
            System.out.println("Too long!");
        }
    }

    private static void someFunction() {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
