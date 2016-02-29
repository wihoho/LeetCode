/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 7/12/2015.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxPosition = 0;

        for(int i = 0;;) {
            maxPosition = maxPosition < i + nums[i] ? i + nums[i] : maxPosition;
            if (maxPosition >= nums.length-1) {
                return true;
            }

            if (i < maxPosition) {
                i ++;
            } else {
                return false;
            }

        }
    }
}
