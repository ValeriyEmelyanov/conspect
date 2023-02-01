package algorithms.binarysearch;

public class Main {
    public static int binarySearch(int[] sortedArray, int element) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int current = sortedArray[middle];

            if (current == element) {
                return middle;
            }

            if (current < element) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    <T extends Comparable<T>> int binarySearchGeneralized(T[] sortedArray, T element) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            T current = sortedArray[middle];
            int compareResult = current.compareTo(element);

            if (compareResult == 0) {
                return middle;
            }

            if (compareResult < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i * 10;
        }
        System.out.println(binarySearch(sortedArray, 70));
        System.out.println(binarySearch(sortedArray, 7));
    }
}
