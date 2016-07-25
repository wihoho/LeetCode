/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/6/2016.
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            }

            num /= 4;
        }

        return true;
    }

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(4));
        System.out.println(powerOfFour.isPowerOfFour(15));
        System.out.println(powerOfFour.isPowerOfFour(16));
    }

}
