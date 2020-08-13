package regexp.examples;

import java.util.Scanner;

/**
 * Need to write a regular expression that can match any number:
 *   - A number can be positive or negative.
 *     If it is negative, then it should start with a '-'.
 *     If it is positive, it may start with a '+'.
 *     If it doesn't start with either '+' or '-' it is considered positive.
 *   - A number representation can't be padded with leading zeroes.
 *     For example, 001 is not a valid number (but 0 is).
 *   - A number can have a fractional part.
 *     A delimiter between an integer part and a fractional part can be either a dot . or a comma ,.
 *     A fractional part can't be padded with trailing zeros: for example, 1.01 and 1.0 are valid numbers,
 *     but 1.00 and 1.10 are not.
 */
public class NumberMatchingExample {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        scanner.close();

        String regex = "(^|\\b)[+-]?(0|[1-9]\\d*)([.,](0|\\d*[1-9]))?(\\b|$)";

        System.out.println(number.matches(regex) ? "YES" : "NO");
    }
}
