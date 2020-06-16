package algorithms.reversing_strng_xor;

/**
 * Реверсирование строки.
 * Решение будет опираться на то, что:
 *   (A XOR B) XOR B = A
 *   (A XOR B) XOR A = B
 */
public class Main {
    public static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int high;
        for (int low = 0; low < arr.length / 2; low++) {
            high = arr.length - 1 - low;
            arr[low] = (char) (arr[low] ^ arr[high]);
            arr[high] = (char) (arr[low] ^ arr[high]);
            arr[low] = (char) (arr[low] ^ arr[high]);
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("12345"));
        System.out.println(reverseString("123456"));
    }
}
