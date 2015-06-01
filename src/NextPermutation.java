import java.util.Arrays;

/**
 * Created by GongLi on 24/5/15.
 */
public class NextPermutation {


    public static void main(String[] args) {
        int[] nums = {1, 1};
        nextPermutation(nums);

        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {

        if (nums.length == 0 || nums.length == 1)
            return;

        int runner = nums.length - 1;
        while (runner > 0 && nums[runner - 1] >= nums[runner]) {
            runner--;
        }

        if (runner == 0) {
            Arrays.sort(nums);
            return;
        }

        int runner2 = nums.length - 1;
        while (nums[runner2] <= nums[runner - 1]) {
            runner2--;
        }

        // exchange runner2 & runner -1
        int temp = nums[runner2];
        nums[runner2] = nums[runner - 1];
        nums[runner - 1] = temp;

        Arrays.sort(nums, runner, nums.length);


    }
}
