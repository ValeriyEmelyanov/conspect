package stream_api.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Example {
    public static void main(String[] args) {
        // https://javarush.ru/groups/posts/2866-funkcionaljhnihe-interfeysih-v-java

        // Predicate - проверка соблюдения условия
        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
        System.out.println(isEvenNumber.test(3));

        // Consumer (потребитель) - принимает в качестве входного аргумента объект типа T,
        // совершает некоторые действия, но при этом ничего не возвращает
        Consumer<String> greetings = x -> System.out.println("Hello " + x + "!!!");
        greetings.accept("World");

        // Supplier (поставщик) - не принимает никаких аргументов, но возвращает некоторый объект типа T
        List<String> names = Arrays.asList("Elena", "John", "Alex", "Jim", "Sara");
        Supplier<String> randomName = () -> {
            int index = (int) (Math.random() * names.size());
            return names.get(index);
        };
        System.out.println(randomName.get());

        // Function - принимает аргумент T и приводит его к объекту типа R,
        // который и возвращается как результат
        Function<Integer, String> convetrer = x -> "<" + String.valueOf(x) + ">";
        System.out.println(convetrer.apply(101));

        // UnaryOperator - принимает в качестве параметра объект типа T,
        // выполняет над ним некоторые операции и возвращает результат операций в виде объекта того же типа T
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(9));
    }
}
