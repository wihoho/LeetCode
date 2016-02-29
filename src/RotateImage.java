/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 26/11/2015.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;

        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;

        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;

        RotateImage ro = new RotateImage();
        ro.rotate(matrix);

        System.out.println();
    }

    public void rotate(int[][] matrix) {
        rotate(matrix, matrix.length, 0, matrix.length - 2);
    }

    public void rotate(int[][] matrix, int n, int level, int maxJ) {
        if (maxJ < 0) {
            return;
        } else {

            int i = level;
            for (int j = 0; j <= maxJ; j++) {
                int tmp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - i - j - 1][i];
                matrix[n - i - j - 1][i] = matrix[n - i - 1][n - i - j - 1];
                matrix[n - i - 1][n - i - j - 1] = matrix[i + j][n - i - 1];
                matrix[i + j][n - i - 1] = tmp;
            }

            rotate(matrix, n, level + 1, maxJ - 2);
        }
    }
}
