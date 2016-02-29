/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 2/12/2015.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int result = maximumSubArray.maxSubArray(nums);
        System.out.println(result);

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int runner = 0;

        for (int i = 0; i < nums.length; i++) {
            runner += nums[i];

            if (max < runner) {
                max = runner;
            }

            if (runner < 0)
                runner = 0;
        }

        return max;
    }
}
