/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/7/2016.
 */
public class GuessNumberTwo {

    public int getMoneyAmount(int n) {
        if (n < 1) return 0;
        int[][] dp = new int[n + 1][n + 1];

        return get(dp, 1, n);
    }

    private int get(int[][] dp, int x, int y) {
        if (x >= y) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        int max = Integer.MAX_VALUE;

        for (int z = x; z <= y; z++) {
            max = Math.min(Math.max(get(dp, x, z - 1) + z, get(dp, z + 1, y) + z), max);
        }

        dp[x][y] = max;
        return max;
    }

    public static void main(String[] args) {
        GuessNumberTwo guessNumberTwo = new GuessNumberTwo();
        System.out.println(guessNumberTwo.getMoneyAmount(2));
    }


}
