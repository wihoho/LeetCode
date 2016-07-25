/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class CombinationSumFiur {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        CombinationSumFiur combinationSumFiur = new CombinationSumFiur();
        combinationSumFiur.combinationSum4(nums, 32);
    }
}
