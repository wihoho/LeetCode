import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 13/6/2016.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candiates = {2, 3, 7};
        List<List<Integer>> result = new CombinationSum().combinationSum(candiates, 7);
        System.out.printf("");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, 0, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void solve(int[] candidates, int pos, int target, int runner, List<Integer> current, List<List<Integer>> result) {
        if (runner > target) {
            return;
        } else if (runner == target) {
            result.add(new ArrayList<>(current));
        } else {

            for (int i = pos; i < candidates.length; i++) {
                if (i != pos && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                current.add(candidates[i]);
                solve(candidates, i, target, runner + candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }

}
