package patterns.behavioral_patterns.strategy_min_max;

import java.util.Scanner;

/**
 * based on the JB Academy
 * Implement algorithms to find max and min values in a given array.
 * The class Finder represents the general finding algorithm itself.
 * find(int[] numbers) method returns the result of finding according to the specified strategy.
 * If the array is empty, the Finder should return Integer.MAX_VALUE in case of finding the min value
 * and Integer.MIN_VALUE in case of finding the max value.
 */
public class MinMaxFinder {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers = null;

        numbers = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            numbers[i] = Integer.parseInt(elements[i]);
        }

        final String type = scanner.nextLine();
        Finder finder = null;
        switch (type) {
            case "MIN":
                finder = new Finder(new FindMin());
                break;
            case "MAX":
                finder = new Finder(new FindMax());
                break;
            default:
                break;
        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}
