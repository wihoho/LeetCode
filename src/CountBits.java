/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class CountBits {
    public int[] countBits(int num) {
        if (num < 0) return new int[0];

        int[] result = new int[num + 1];
        result[0] = 0;

        int offset = 1;
        for (int i = 1; i <= num; i++) {
            if (offset * 2 == i) {
                offset *= 2;
            }

            result[i] = result[i-offset] + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        countBits.countBits(5);
    }
}
