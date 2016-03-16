import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wihoho on 5/3/16.
 */
public class SubSetsTwo {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, nums.length, new ArrayList<>(), result);
        return result;
    }

    public void subset(int[] nums, int start, int size, List<Integer> current, List<List<Integer>> total) {
        total.add(new ArrayList<Integer>(current));

        for (int i = start; i < size; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                subset(nums, i+1, size, current, total);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubSetsTwo subSetsTwo = new SubSetsTwo();
        List<List<Integer>> result = subSetsTwo.subsetsWithDup(nums);
        System.out.println();
    }
}
