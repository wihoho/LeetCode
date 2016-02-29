/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/12/2015.
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();

        System.out.println(pow.myPow(2, 2));
        System.out.println(pow.myPow(8.95371, -1));

    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }

        double result;
        if (n == 1) {
            result = x;
        } else {

            if (n % 2 == 0) {
                double temp = myPow(x, n / 2);
                result = temp * temp;
            } else {
                result = x * myPow(x, n - 1);
            }
        }

        if (flag) {
            return 1.0 / result;
        } else {
            return result;
        }
    }
}
