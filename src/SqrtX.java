/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 29/2/2016.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int temp = x / 2;
        int product = temp * temp;
        while (product < x) {
            if (product > x) {
                temp = temp / 2;
            } else if (product < x) {
                temp = temp * 2 + 1;
            } else {
                return temp;
            }

            product = temp * temp;
        }

        return temp;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(9));
    }
}
