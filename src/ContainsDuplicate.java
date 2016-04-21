import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/4/2016.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        return nums.length == set.size();
    }
}
