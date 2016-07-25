import java.util.TreeSet;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class MaxSumSubMatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        int row = matrix.length;
        int column = matrix[0].length;

        int bestSum = -1;
        int bestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            for (int j = i; j < column; j++) {
                int[] temp = new int[row];
                for (int m = 0; m < row; m++) {
                    for (int n = i; n <= j; n++) {
                        temp[m] += matrix[m][n];
                    }
                }

                TreeSet<Integer> set = new TreeSet<>();
                int currentValue = 0;
                for (int p = 0; p < row; p++) {
                    currentValue += temp[p];

                    if (currentValue < k) {
                        if (bestDiff > k - currentValue) {
                            bestDiff = k - currentValue;
                            bestSum = currentValue;
                        }
                    } else if (currentValue == k) {
                        return currentValue;
                    }

                    try {
                        int candidate1 = set.ceiling(currentValue - k);
                        set.add(currentValue);

                        if (bestDiff > candidate1 + k - currentValue) {
                            bestSum = currentValue - candidate1;
                            bestDiff = candidate1 + k - currentValue;
                        }

                    } catch (Exception e) {
                        set.add(currentValue);
                        continue;
                    }


                }
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        int[][] matrx = new int[3][4];
        matrx[0][0] = 5;
        matrx[0][1] = -4;
        matrx[0][2] = -3;
        matrx[0][3] = 4;

        matrx[1][0] = -3;
        matrx[1][1] = -4;
        matrx[1][2] = 4;
        matrx[1][3] = 5;

        matrx[2][0] = 5;
        matrx[2][1] = 1;
        matrx[2][2] = 5;
        matrx[2][3] = -4;

        MaxSumSubMatrix maxSumSubMatrix = new MaxSumSubMatrix();
        System.out.println(maxSumSubMatrix.maxSumSubmatrix(matrx, 10));
    }
}
