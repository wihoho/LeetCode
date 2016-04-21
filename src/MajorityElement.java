/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 31/3/2016.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else {
                count = majority == nums[i] ? count + 1 : count - 1;
            }
        }

        return majority;
    }
}
