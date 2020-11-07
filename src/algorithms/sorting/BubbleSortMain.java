package algorithms.sorting;

import java.util.Arrays;

public class BubbleSortMain {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        bubbleSort(new int[] { 21, 23, 19, 30, 11, 28 })
                ));
    }

    public static int[] bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
