/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/11/2015.
 */
public class JumpGameTwo {
    public static void main(String[] args) {
        int[] input = {0};
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        System.out.println(jumpGameTwo.jump(input));
    }

    public int jump(int[] nums) {
        int size = nums.length;
        if (size <= 1) {
            return 0;
        }

        int last = 0;
        int cur = 0;
        int step = 0;

        for (int i = 0; i < size; i++) {
            if (i > last) {
                last = cur;
                step++;
            }
            cur = Math.max(cur, nums[i] + i);

            if (cur >= size - 1) {
                return step + 1;
            }
        }

        return step;
    }
}
