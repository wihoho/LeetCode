/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 27/6/2016.
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int[] candies = new int[ratings.length];

        // left -> right
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = candies[0];
        for (int i = 1; i < ratings.length; i++) {
            total += candies[i];
        }

        return total;
    }

}
