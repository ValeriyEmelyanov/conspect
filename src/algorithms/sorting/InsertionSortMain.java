package algorithms.sorting;

import java.util.Arrays;

public class InsertionSortMain {
    public static void main(String[] args) {
        int[] arr1 = insertionSort(new int[]{21, 23, 19, 30, 11, 28});
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] insertionSort(int[] array) {
        // iterating over elements in the unsorted part of the array
        for (int i = 1; i < array.length; i++) {
            // take the next element
            int element = array[i];
            int j = i - 1;

            // find a suitable position to insert
            while (j >= 0 && array[j] > element) {
                // shift element to the right
                array[j + 1] = array[j];
                j--;
            }
            // insert the element in the found position in the sorted part
            array[j + 1] = element;
        }        
        return array;
    }
}
