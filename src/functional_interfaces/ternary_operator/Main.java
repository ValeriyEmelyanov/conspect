package functional_interfaces.ternary_operator;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength =
                Operator.ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply("Hello"));
    }
}
