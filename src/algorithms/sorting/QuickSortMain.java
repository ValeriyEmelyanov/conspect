package algorithms.sorting;

import java.util.Arrays;

public class QuickSortMain {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        quickSort(new int[]{21, 23, 19, 30, 11, 28})
                ));
    }

    public static int[] quickSort(int[] array) {
        recursionQuickSort(array, 0, array.length - 1);
        return array;
    }

    private static void recursionQuickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }

        if (low > high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int middleElement = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < middleElement) {
                i++;
            }
            while (array[j] > middleElement) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            recursionQuickSort(array, low, j);
        }
        if (high > i) {
            recursionQuickSort(array, i, high);
        }
    }
}
