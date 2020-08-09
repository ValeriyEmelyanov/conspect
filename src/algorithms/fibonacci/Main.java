package algorithms.fibonacci;

public class Main {

    private static int fib(int num) {
        if (num <= 1) {
            return num;
        }

        if (num == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 2; i < num; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
