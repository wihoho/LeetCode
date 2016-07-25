/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 14/7/2016.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n <= 0) return -1;

        int result = 0;
        int start = 1;

        while (start * start <= n) {
            result +=1;
            start += 1;
        }

        return result;
    }


    public static void main(String[] args) {
        BulbSwitcher bulbSwitcher = new BulbSwitcher();
        System.out.println(bulbSwitcher.bulbSwitch(9999999));
    }
}
