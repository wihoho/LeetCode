import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 2/12/2015.
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] status = new int[n];
        for(int i = 0; i < n; i ++) {
            status[i] = -1;
        }

        NQueen(result, status, 0, n, new ArrayList<>());

        return result.size();
    }

    public void NQueen(List<List<String>> result, int[] status, int row, int n, List<String> current) {
        if (row == n) {
            List<String> newList = new ArrayList<>();
            result.add(newList);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(status, row, i)) {
                    status[row] = i;
                    current.add(calculate(n, i));
                    NQueen(result, status, row + 1, n, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    public boolean isValid(int[] status, int row, int column) {
        for (int i = 0; i < row; i++) {
            int oldColumn = status[i];

            if (oldColumn == column) {
                return false;
            }

            int rowSize = row - i;
            int columnSize = Math.abs(oldColumn - column);

            if (rowSize == columnSize) {
                return false;
            }
        }

        return true;
    }

    public String calculate(int n, int i) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < n; j++) {
            if (j == i) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }

        return sb.toString();
    }
}
