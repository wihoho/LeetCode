import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 7/6/2016.
 */
public class NQueenLint {

    public static void main(String[] args) {
        NQueenLint nQueenLint = new NQueenLint();
        List<List<String>> result = nQueenLint.solveNQueens(4);
        System.out.println();
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(new ArrayList<>(), n, result);
        List<List<String>> finalResult = result.stream().map(item -> draw(item, n)).collect(Collectors.toList());
        return finalResult;
    }

    private List<String> draw(List<Integer> one, int n) {
        List<String> result = new ArrayList<>();
        for(Integer i: one) {
            StringBuffer sb = new StringBuffer();
            for(int x = 0; x < n; x ++) {
                if (i == x) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private void solve(List<Integer> columns, int n, List<List<Integer>> result) {
        if (columns.size() == n) {
            result.add(new ArrayList<>(columns));
            return;
        }

        for(int i = 0; i < n; i ++) {
            if (checkValid(columns, i)) {
                columns.add(i);
                solve(columns, n, result);
                columns.remove(columns.size()-1);
            }
        }
    }

    private boolean checkValid(List<Integer> columns, int nextColumn) {
        int currentRow = columns.size();
        for(int i = 0; i < columns.size(); i ++) {
            if (columns.get(i) == nextColumn) {
                return false;
            }

            int left = Math.abs(currentRow - i);
            int right = Math.abs(nextColumn - columns.get(i));
            if (left == right) {
                return false;
            }
        }

        return true;
    }

}
