import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 2/3/16.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, n, 1, k, new ArrayList<>());
        return result;

    }

    public void combine(List<List<Integer>> result, int n, int start, int k, List<Integer> current) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= n; i ++) {
            current.add(i);
            combine(result, n, i + 1, k - 1, current);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();

        List<List<Integer>> result = combinations.combine(4,2);
        System.out.println();
    }
}
