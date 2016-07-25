/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 26/4/2016.
 */
public class SingleNumberThree {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int i = 0;
        for (; i < 32; i++) {
            if ((xor >> i & 1) == 1) {
                break;
            }
        }

        int a = 1;
        int b = 1;
        for (int j = 0; j < nums.length; j++) {
            int current = nums[j];
            if ((current >> i & 1) == 1) {
                a ^= current;
            } else {
                b ^= current;
            }
        }

        a ^= 1;
        b ^= 1;

        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
}
