package functional_interfaces.ternary_operator;

import java.util.function.Function;
import java.util.function.Predicate;

public class Operator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> condition.test(x)
                ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}
