package io.console_pwd;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 * The Password example is a prototype program for changing a user's password.
 * It demonstrates several Console methods.
 *
 * Важно, что доступ к консоли мы можем получить только из самой консоли.
 * При запуске, например, в среде разработки вызов System.console() будет возвращать значение null.
 *
 * Пример компиляции:
 * javac D:\projects\conspect\src\io\console_pwd\Password.java
 *
 * Пример выполнения:
 * java -cp D:\projects\conspect\src io.console_pwd.Password
 */
public class Password {
    public static void main(String[] args) throws IOException {

        Console console = System.console();
        if (console == null) {
            System.err.println("No console");
            System.exit(1);
        }

        String login = console.readLine("Enter your login: ");
        char[] oldPassword = console.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char[] newPassword1 = console.readPassword("Enter your new password: ");
                char[] newPassword2 = console.readPassword("Enter new password again: ");
                noMatch = !Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    console.format("Password dont`t match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    console.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);

            Arrays.fill(oldPassword, ' ');
        }
    }

    // Dummy verify method
    private static boolean verify(String login, char[] password) {
        // This method always returns true in this example.
        // Modify this method to verify password according to your rules.
        return true;
    }

    // Dummy change method
    private static void change(String login, char[] password) {
        // Modify this method to change password according to your rules.
    }
}
