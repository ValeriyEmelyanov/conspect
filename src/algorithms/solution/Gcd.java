package algorithms.solution;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Определение наибольшего общего делителя.
 */
public class Gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n1 = scanner.nextLong();
        long n2 = scanner.nextLong();
        System.out.println(gcd(n1, n2));
    }

    private static Long gcd(long arg1, long arg2) {
        long n1 = arg1;
        long n2 = arg2;
        while (n1 > 0 && n2 > 0) {
            if (n1 >= n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return max(n1, n2);
    }
}

