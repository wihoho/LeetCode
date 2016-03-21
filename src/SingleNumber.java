/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 21/3/2016.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int i: nums) {
            temp ^= i;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(2|2|2);
    }
}
