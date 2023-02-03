package algorithms.solution;

import java.util.Arrays;

public class DividingArr {

    /**
     * Дан массив N и число k <= len(N)/2
     * Как разбить массив N на k подмассивов так,
     * чтобы длина самого длинного и самого короткого подмассивов отличалась не более чем на 1.
     *
     * @param args
     */
    public static void main(String[] args) {
        int len = 26;
        int[] n = new int[len];
        for (int i = 0; i < n.length; i++) {
            n[i] = i;
        }

        int k = 7;
        int size = n.length / k;
        int numOfSizePlusOne = n.length % k;

        int[][] result = new int[k][];
        int curResInd = -1;
        for (int i = 0; i < n.length; i++) {
            int subInd = i;
            if (curResInd > 0) {
                for (int j = 0; j < curResInd; j++) {
                    subInd -= result[j].length;
                }
            }

            if (curResInd < 0 || subInd > result[curResInd].length - 1) {
                curResInd++;
                result[curResInd] = new int[curResInd < numOfSizePlusOne ? size + 1 : size];
                subInd = 0;
            }

            result[curResInd][subInd] = n[i];
        }

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
