package patterns.behavioral_patterns.templatemethod_meal_cooking;

import java.util.Scanner;

/**
 * Template Method describes the common algorithm
 * while subclasses implement steps of this algorithm.
 * This pattern lets the subclasses implement the steps of the algorithm
 * without changing that algorithm's skeleton.
 *
 * An abstract base class implements standard algorithm steps
 * and can provide a default implementation for custom steps.
 * Specific subclasses provide concrete implementation for each of these steps.
 *
 * Template Method has the following components:
 * - Abstract Class describes primitive operations and the template method itself
 *   which calls primitive operations;
 * - Concrete Class implements the primitive operations.
 *
 * Template Method is applicable in the following cases:
 * - When the behavior of an algorithm can vary,
 *   you let subclasses implement the behavior through overriding;
 * - When you want to avoid code duplication, implementing variations of the algorithm in subclasses.
 */
public class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String order = scanner.nextLine();
        scanner.close();
        Meal meal = null;
        if ("Sandwich".equalsIgnoreCase(order)) {
            meal = new Sandwich();
            meal.doMeal();
        } else if ("Steak".equalsIgnoreCase(order)) {
            meal = new Steak();
            meal.doMeal();
        } else {
            System.out.println("Error");
        }
    }
}
