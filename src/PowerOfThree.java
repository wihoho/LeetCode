/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 13/6/2016.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int logNum = (int) (Math.log(n) / Math.log(3));
        if (Math.pow(3, logNum) == n || Math.pow(3, logNum+1) == n) return true;
        else return false;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        boolean r1 = powerOfThree.isPowerOfThree(243);
        boolean r2 = powerOfThree.isPowerOfThree(9);
        System.out.println();
    }
}
