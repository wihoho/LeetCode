/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 14/7/2016.
 */
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) return new int[0];

        int m = nums1.length;
        int n = nums2.length;

        int[][][] dp = new int[m + 1][n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i][1] = nums2[i - 1];
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0][1] = nums1[i - 1];
        }

        for (int p = 1; p <= k; p++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int temp1 = dp[i - 1][j][k - 1];
                    temp1 = temp1 * 10 + nums1[i - 1];

                    int temp2 = dp[i][j - 1][k - 1];
                    temp2 = temp2 * 10 + nums2[j - 1];

                    int temp3 = dp[i - 1][j][k];
                    int temp4 = dp[i][j - 1][k];

                    dp[i][j][k] = Math.max(Math.max(Math.max(temp1, temp2), temp3), temp4);
                }
            }
        }

        int result = dp[m][n][k];
        return null;
    }

    public static void main(String[] args) {
        CreateMaxNumber createMaxNumber = new CreateMaxNumber();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        createMaxNumber.maxNumber(nums1, nums2, 5);
    }
}
