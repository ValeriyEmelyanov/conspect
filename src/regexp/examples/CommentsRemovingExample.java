package regexp.examples;

import java.util.Scanner;

/**
 * Examples:
 *
 */
public class CommentsRemovingExample {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String codeWithComments = scanner.nextLine();
        scanner.close();

        String result = codeWithComments
                .replaceAll("/\\*.*?\\*/", "")
                .replaceAll("//.*$", "");

        System.out.println(result);

    }
}
