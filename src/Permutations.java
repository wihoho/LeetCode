import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/11/2015.
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, -1, 1, 2, -1, 2, 2, -1};
        Arrays.sort(nums);
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] visisted = new int[nums.length];
        permutae(result, nums, visisted, new ArrayList<Integer>());
        return result;
    }

    public void permutae(List<List<Integer>> result, int[] nums, int[] visited, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }

            visited[i] = 1;
            current.add(nums[i]);
            permutae(result, nums, visited, current);
            current.remove(current.size() - 1);
            visited[i] = 0;
        }
    }

}
