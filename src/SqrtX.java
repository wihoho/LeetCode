/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 29/2/2016.
 *
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (x / middle == middle ) return middle;
            else if (x / middle < middle) end = middle - 1;
            else start = middle + 1;
        }

        return end;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(2));
    }
}
