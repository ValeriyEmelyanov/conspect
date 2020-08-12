package regexp.examples;

import java.util.Scanner;

public class IPAddressExample {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String imput = scanner.nextLine();
        scanner.close();

        // более длинный вариант
        // 0-9 или 10-99 или 100-199 или 200-249 или 250-255
        // "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"

        // 0-199 или 200-249 или 250-255
        final String bytePattern = "(1?\\d?\\d|2[0-4]\\d|25[0-5])";
        final String ipPattern = String.join("\\.", bytePattern, bytePattern, bytePattern, bytePattern);

        boolean result = imput.matches(ipPattern);

        System.out.println(result ? "YES" : "NO");
    }
}
