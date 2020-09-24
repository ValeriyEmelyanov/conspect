package stream_api.examples;

import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class ProductOfRange {
    public static void main(String[] args) {
        // Write a lambda expression that accepts two long arguments as a range borders
        // and calculates (returns) product of all numbers in this range (inclusively).
        // It's guaranteed that 0 <= left border <= right border.
        // If left border == right border then the result is any border.

        long start = 1;
        long end = 4;

        long result = LongStream.rangeClosed(start, end).reduce((v1, v2) -> v1 * v2).orElseThrow();
        System.out.println(result);

        LongBinaryOperator binaryOperator = (x, y) -> LongStream.rangeClosed(x, y).reduce((v1, v2) -> v1 * v2).orElseThrow();
        long ptodauct = binaryOperator.applyAsLong(start, end);
        System.out.println(ptodauct);
    }
}
