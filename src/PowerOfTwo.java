/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/4/2016.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return false;
        int temp = n & (n - 1);
        return temp == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(0));
        System.out.println(powerOfTwo.isPowerOfTwo(4));
        System.out.println(powerOfTwo.isPowerOfTwo(5));
        System.out.println(powerOfTwo.isPowerOfTwo(1));

    }
}
