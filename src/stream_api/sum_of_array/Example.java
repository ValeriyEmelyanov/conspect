package stream_api.sum_of_array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 100};

        int sum1 = IntStream.of(arr).sum();
        int sum2 = Arrays.stream(arr).sum();
        int sum3 = Arrays.stream(arr).reduce(Integer::sum).orElse(0);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}
