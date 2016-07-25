/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/7/2016.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }

        for(int i = 0; i < nums.length; i ++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
