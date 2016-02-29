/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 8/12/2015.
 */
public class SpiralMatrixTwo {
    public static void main(String[] args) {
        SpiralMatrixTwo spiralMatrixTwo = new SpiralMatrixTwo();
        int[][] result = spiralMatrixTwo.generateMatrix(1);
        System.out.println(result);
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        if (n == 1) {
            result[0][0] = 1;
            return result;
        }

        generate(0, n, 1, result);
        return result;
    }

    public void generate(int level, int n, int start, int[][] result) {
        for (int i = level; i < n - level - 1; i++) {
            result[level][i] = start;
            start++;
        }

        for (int i = level; i < n - level - 1; i++) {
            result[i][n - level - 1] = start;
            start++;
        }

        for (int i = n - level - 1; i > level; i--) {
            result[n - level - 1][i] = start;
            start++;
        }

        for (int i = n - level - 1; i > level; i--) {
            result[i][level] = start;
            start++;
        }

        if (start == n * n) {
            result[level+1][level+1] = start;
            return;
        } else if (start < n * n){
            generate(level + 1, n, start, result);
        }
    }

}
