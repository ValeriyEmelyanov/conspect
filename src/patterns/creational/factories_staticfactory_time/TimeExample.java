package patterns.creational.factories_staticfactory_time;

import java.util.Scanner;

/**
 * The class Time implements the following static factory methods:
 *  - noon() returns an instance initialized with 12 hours, 0 minutes, and 0 seconds,
 *  - midnight() returns an instance initialized with 0 hours, 0 minutes, and 0 seconds,
 *  - of(int hour, int minute, int second) returns an instance initialized
 *  with passed hour, minute and second
 *  if the passed arguments are correct (hour: 0-23, minute: 0-59, seconds: 0-59),
 *  otherwise, null.
 *  - ofSeconds(long seconds) returns an instance initialized with seconds passed since midnight
 *  (days are skipped).
 * Note: in a real application, it may be better to throw an exception
 * than return null when arguments are incorrect.
 */
public class TimeExample {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.getHour(), time.getMinute(), time.getSecond()));
        }
    }
}
