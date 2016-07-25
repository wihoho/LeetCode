/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/6/2016.
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int start = 0;
        int end = 31;

        while (start < end) {
            n = swap(n, start, end);
            start++;
            end--;
        }

        return n;
    }

    private int swap(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            n ^= (1 << i) | (1 << j);
        }

        return n;

    }


}
