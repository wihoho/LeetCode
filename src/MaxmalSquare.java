/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/7/2016.
 */
public class MaxmalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int row = matrix.length;
        if (row == 0) return 0;

        int column = matrix[0].length;
        if (column == 0) return 0;

        int[][] dp = new int[row][column];
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        int result = dp[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }

    public static void main(String[] args) {
        char[][] matrx = new char[2][2];
        matrx[0][0] = '1';
        matrx[0][1] = '1';
        matrx[1][0] = '1';
        matrx[1][1] = '1';

        MaxmalSquare maxmalSquare = new MaxmalSquare();
        maxmalSquare.maximalSquare(matrx);
    }

}
