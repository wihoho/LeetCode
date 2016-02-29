/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 19/1/2016.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[2][3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 5;

        grid[1][0] = 3;
        grid[1][1] = 2;
        grid[1][2] = 1;

        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] X = new int[M][N];
        X[0][0] = grid[0][0];

        for(int i = 1; i < M; i ++) {
            X[i][0] = X[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < N; i ++) {
            X[0][i] = X[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < M; i ++) {
            for(int j = 1; j < N; j ++) {
                X[i][j] = Math.min(X[i-1][j], X[i][j-1]) + grid[i][j];
            }
        }


        return X[M - 1][N - 1];
    }
}
