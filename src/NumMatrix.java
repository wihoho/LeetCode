/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 19/5/2016.
 */
public class NumMatrix {
    private int[][] matrix;
    private int[][] help;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int row = matrix.length;

        if (row == 0) {
            return;
        }

        int column = matrix[0].length;

        this.help = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.help[i][j] = j >= 1 ? this.help[i][j - 1] + matrix[i][j] : matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.help == null) return 0;

        int result = 0;

        for (int i = row1; i <= row2; i++) {
            result += col1 >= 1 ? this.help[i][col2] - this.help[i][col1 - 1] : this.help[i][col2];
        }

        return result;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[0][0]);

    }
}
