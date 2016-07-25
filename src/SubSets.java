import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wihoho on 2/3/16.
 */
public class SubSets {

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        subsetsHelper(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, int[] nums, int position, ArrayList<Integer> current) {
        result.add(new ArrayList<>(current));

        if (position == nums.length) {
            return;
        }

        for (int i = position; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            subsetsHelper(result, nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ArrayList<ArrayList<Integer>> result = new SubSets().subsets(nums);
        System.out.printf("");
    }
}
