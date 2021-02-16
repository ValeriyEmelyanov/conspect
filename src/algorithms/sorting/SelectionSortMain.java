package algorithms.sorting;

import java.util.Arrays;

public class SelectionSortMain {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        selectionSort(new int[]{21, 23, 19, 30, 11, 28})
                ));
    }

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        return array;
    }
}
