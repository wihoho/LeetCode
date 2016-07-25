import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/7/2016.
 */
public class ContainDuplicateTwo {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0)
            return false;

        int i = 0;

        TreeSet<Long> set = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            long cur = nums[j];
            long left = cur - t;
            long right = cur + t + 1;

            SortedSet sortedSet = set.subSet(left, right);
            if (!sortedSet.isEmpty()) {
                return true;
            }

            set.add(cur);
            if (set.size() >= k + 1) {
                set.remove(nums[i++]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nusm = {4,2};
        ContainDuplicateTwo containDuplicateTwo = new ContainDuplicateTwo();
        containDuplicateTwo.containsNearbyAlmostDuplicate(nusm, 2,1);
    }
}
