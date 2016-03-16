/**
 * Created by wihoho on 1/3/16.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = n * m - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int x = middle / n;
            int y = middle % n;
            if (matrix[x][y] < target) {
                 start = middle + 1;
            } else if (matrix[x][y] > target) {
                end = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
    }
}
