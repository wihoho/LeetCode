import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 3/12/2015.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        int[][] matrix = new int[5][3];
        matrix[0][0] = 2;
        matrix[0][1] = 3;
        matrix[0][2] = 4;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;

        matrix[2][0] = 8;
        matrix[2][1] = 9;
        matrix[2][2] = 10;

        matrix[3][0] = 11;
        matrix[3][1] = 12;
        matrix[3][2] = 13;

        matrix[4][0] = 14;
        matrix[4][1] = 15;
        matrix[4][2] = 16;


//        matrix[1][2] = 6;
//
//        matrix[2][0] = 7;
//        matrix[2][1] = 8;
//        matrix[2][2] = 9;
//
//        matrix[3][0] = 10;
//        matrix[3][1] = 11;
//        matrix[3][2] = 12;

        List<Integer> result = spiralMatrix.spiralOrder(matrix);

        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int b = matrix.length;
        if (b == 0) {
            return new ArrayList<>();
        }

        int a = matrix[0].length;

        if (a == 0 && b == 0) {
            return new ArrayList<>();
        } else if (a == 1) {
            for (int i = 0; i < b; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        } else if (b == 1) {
            for (int i = 0; i < a; i++) {
                result.add(matrix[0][i]);
            }

            return result;
        }

        spiral(matrix, b, a, 0, result);

        return result;
    }

    public void spiral(int[][] matrx, int b, int a, int k, List<Integer> result) {
        if (k > a - k - 1 || k > b - k - 1) {
            return;
        }

        if (k == a - k - 1 && k == b - k - 1) {
            result.add(matrx[k][k]);
            return;
        }

        for (int i = k; i < a - k - 1; i++) {
            result.add(matrx[k][i]);
        }


        for (int i = k; i < b - k - 1; i++) {
            result.add(matrx[i][a - k - 1]);
        }

        if (k == b - k - 1) {
            result.add(matrx[b - k - 1][a - k - 1]);
        } else {

            for (int i = a - k - 1; i > k; i--) {
                result.add(matrx[b - k - 1][i]);
            }
        }
        if (k == a - k - 1) {
            result.add(matrx[b - k - 1][k]);
        } else {
            for (int i = b - k - 1; i > k; i--) {
                result.add(matrx[i][k]);
            }
        }


        spiral(matrx, b, a, k + 1, result);
    }
}
