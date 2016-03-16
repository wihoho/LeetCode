import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wihoho on 2/3/16.
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subSets(nums, 0, result);
        return result;
    }

    public void subSets(int[] nums, int start, List<List<Integer>> result) {
        if (start >= nums.length) {
            return;
        }

        List<List<Integer>> temp = new ArrayList<>();
        result.forEach(item -> {
            List<Integer> cur = new ArrayList<Integer>(item);
            cur.add(nums[start]);
            temp.add(cur);
        });

        result.addAll(temp);

        subSets(nums, start + 1, result);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        SubSets subSets = new SubSets();
        List<List<Integer>> result = subSets.subsets(nums);

        System.out.println();

    }
}
