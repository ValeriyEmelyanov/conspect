package regexp.example_login;

import java.util.Scanner;

/**
 * login can contain:
 *  any Latin letter,
 *  a number,
 *  the underscore character _,
 *  the dollar sign $.
 * The length must be no less than 5 characters and no more than 12 characters.
 */
public class Example {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        scanner.close();

        // "\\s*[a-zA-Z0-9_$]{5,12}\\s*" == "\\s*[\\w$]{5,12}\\s*"
        // the regex "\\s*" is a very useful practical tool for finding whitespace characters
        String loginRegex = "\\s*[\\w$]{5,12}\\s*";

        boolean isCorrect = login.matches(loginRegex);

        System.out.println(isCorrect);
    }
}
