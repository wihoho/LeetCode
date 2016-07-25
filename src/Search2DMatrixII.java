/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/7/2016.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = matrix.length;
        int column = matrix[0].length;

        if (column == 0) {
            return false;
        }

        int x = row - 1;
        int y = 0;
        while (x >= 0 && y <= column - 1) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }

        return false;
    }
}
