/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/7/2016.
 */
public class WaterJug {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y == z) {
            return true;
        }

        int gcd = gcd(x, y);
        if (gcd == 0) return false;
        return z % gcd == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x%y);
    }

    public static void main(String[] args) {
        WaterJug waterJug = new WaterJug();
        System.out.println(waterJug.canMeasureWater(4,6,8));
    }
}
