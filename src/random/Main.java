package random;

import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        //System.out.println(getRandomInRange(1, 10));
        //System.out.println(getRnd(8));
        System.out.println(getRndInRange(5, 9));
    }

    /**
     * Returns the specified number of pseudorandom integers from the given range
     * (inclusive both lower and upper borders).
     * @param lower lower border (inclusive)
     * @param upper upper border ((inclusive)
     * @return the specified number of pseudorandom integers from the given range
     */
    public static int getRandomInRange(int lower, int upper) {
        int intervalLength = upper - lower + 1;
        return RANDOM.nextInt(intervalLength) + lower;
    }

    /**
     * Returns the specified number of pseudorandom integers from 0 to max
     * (inclusive both lower and upper borders).
     * @param max upper border ((inclusive)
     * @return the specified number of pseudorandom integers from 0 to max
     */
    public static int getRnd(int max) {
        return (int) (Math.random() * ++ max);
    }

    /**
     * Returns the specified number of pseudorandom integers from the given range
     * (inclusive both lower and upper borders).
     * @param min lower border (inclusive)
     * @param max upper border ((inclusive)
     * @return the specified number of pseudorandom integers from the given range
     */
    public static int getRndInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
