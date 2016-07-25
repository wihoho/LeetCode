import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 30/6/2016.
 */
public class CombinationSumThree {
    public static void main(String[] args) {
        CombinationSumThree combinationSumThree = new CombinationSumThree();
        List<List<Integer>> result = combinationSumThree.combinationSum3(3, 15);
        System.out.println(combinationSumThree);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        help(k, n, 0, 0, new ArrayList<>(), result, 1);
        return result;
    }

    private void help(int k, int n, int currentCount, int currentValue, List<Integer> current, List<List<Integer>> result, int index) {
        if (currentCount > k || currentValue > n) {
            return;
        }

        if (currentCount == k && currentValue == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentCount == k) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (current.contains(i)) {
                continue;
            }

            current.add(i);
            help(k, n, currentCount + 1, currentValue + i, current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
