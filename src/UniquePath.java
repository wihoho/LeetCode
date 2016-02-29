/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/12/2015.
 */
public class UniquePath {
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        int[][] grid = new int[1][2];
        grid[0][0] = 1;
        grid[0][1] = 0;

        int result = uniquePath.uniquePathsWithObstacles(grid);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[][] result = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++)
            result[i][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            result[1][i] = 1;
        }

        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        return result[m][n];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] result = new int[m][n];

        for(int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = 1;
            } else {
                break;
            }
        }

        for(int j = 0; j < n; j ++) {
            if (obstacleGrid[0][j] == 0) {
                result[0][j] = 1;
            } else {
                break;
            }
        }

        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];

                }
            }
        }

        return result[m-1][n-1];
    }


}
