package generics.generic_static_method;

public class Main {
    public static void main(String[] args) {
        Character[] characters = { 'a', 'b', 'c' };
        print(characters);

        Integer[] integers = {1, 2, 3, 4, 5};
        print(integers);
    }

    public static <E> void print(E[] elements) {
        for (E e : elements) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
