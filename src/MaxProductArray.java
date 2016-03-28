/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 24/3/2016.
 */
public class MaxProductArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            int preMax = max;

            max = Math.max(Math.max(min*nums[i], max*nums[i]), nums[i]);
            min = Math.min(Math.min(min*nums[i], preMax*nums[i]), nums[i]);

            res = Math.max(max, res);
        }

        return res;
    }
}
