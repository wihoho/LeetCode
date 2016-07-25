/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/6/2016.
 */
public class HouseRobberTwo {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int one = rob(nums, 0, nums.length - 2);
        int two = rob(nums, 1, nums.length - 1);
        return Math.max(one, two);
    }

    private int rob(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        int[] dp = new int[j - i + 1];
        dp[0] = nums[i];
        dp[1] = nums[i] > nums[i + 1] ? nums[i] : nums[i + 1];

        for (int runner = i+2; runner <= j; runner++) {
            dp[runner - i] = Math.max(dp[runner - i - 1], dp[runner - i - 2] + nums[runner]);
        }

        return dp[j - i];
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        HouseRobberTwo houseRobberTwo = new HouseRobberTwo();
        houseRobberTwo.rob(nums);
    }
}
