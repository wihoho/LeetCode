/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 14/4/2016.
 */
public class MinimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = 0;
        int sum = nums[0];
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while (right < nums.length) {
            if (sum >= s) {
                if (right == left) {
                    return 1;
                }

                result = Math.min(right - left + 1, result);
                flag = true;
                sum -= nums[left];
                left++;
            } else {
                right++;

                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        if (flag) {
            return result;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MinimumSizeSubArray minimumSizeSubArray = new MinimumSizeSubArray();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minimumSizeSubArray.minSubArrayLen(7, nums));
    }
}
