/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/3/2016.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;

        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }
}
