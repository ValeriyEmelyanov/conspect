package algorithms.solution;

public class FindingMaxInSortedShiftedArr {

    /**
     * Дан массив неповторяющихся чисел, который был отсортирован,
     * а затем циклически сдвинут на неизвестное число позиций.
     * Реализуйте алгоритм поиска максимума в таком массиве.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {30, 31, 32, 33, 34, 45, 1, 2, 6, 7, 10, 17, 18, 19, 20, 29}; // !!!
        System.out.println(getMax(arr));
    }

    private static int getMax(int[] arr) {
        return getMax(arr, 0, arr.length - 1);
    }

    private static int getMax(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        if (arr[left] < arr[right]) return arr[right];
        if (left + 1 == right) return Math.max(arr[left], arr[right]);

        int mid = (left + right) / 2;
        int leftMax = getMax(arr, left, mid - 1);
        int rightMax = getMax(arr, mid, right);

        if (leftMax > rightMax) return leftMax;
        return rightMax;
    }
}
