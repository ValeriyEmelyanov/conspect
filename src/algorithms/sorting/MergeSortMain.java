package algorithms.sorting;

import java.util.Arrays;

public class MergeSortMain {
    public static void main(String[] args) {
        int[] array1 = {30, 21, 23, 19, 28, 11, 23};
        mergeSort(array1, 0, array1.length);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {30, 20, 10, 10, 20, 10};
        mergeSort(array2, 0, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    public static void mergeSort(int[] array, int leftIncl, int rightExcl) {
        // base case: if subarray contains <= 1 items, stop dividing because it is sorted
        if (rightExcl <= leftIncl + 1) {
            return;
        }

        // calculate the index of the middle element
        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        // divide (recursive call)
        mergeSort(array, leftIncl, middle);
        mergeSort(array, middle, rightExcl);

        // merge both sorted subarrays into sorted one
        merge(array, leftIncl, middle, rightExcl);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int i = left;   // index for the left subarray
        int j = middle;  // index for the right subarray
        int k = 0;      // index for the temp array

        // temporary array for merging
        int[] temp = new int[right - left];

        // get the next lesser element from one of two subarrays
        // and then insert it in the temporary array
        // until one of the subarays is empty
        while (i < middle && j < right) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        // insert all the ramaining elements of the left subarray in the temporary array
        for (; i < middle; i++, k++) {
            temp[k] = array[i];
        }

        // insert all the ramaining elements of the right subarray in the temporary array
        for (; j < right; j++, k++) {
            temp[k] = array[j];
        }

        // copy elements from the temporary array to the array
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
