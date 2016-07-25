import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class CountRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || upper < lower) return 0;

        int size = nums.length;
        long[] cum = new long[size];
        cum[0] = nums[0];
        for (int i = 1; i < size; i++) {
            cum[i] = cum[i - 1] + nums[i];
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put((long) 0,1);

        int result = 0;
        for (int i = 0; i < size; i++) {
            long lowerBound = cum[i] - upper;
            long higherBound = cum[i] - lower;

            NavigableMap<Long, Integer> navigableSet = map.subMap(lowerBound, true, higherBound, true);
            Iterator<Integer> iterator = navigableSet.values().iterator();
            while (iterator.hasNext()) {
                result += iterator.next();
            }

            map.merge(cum[i], 1, (a,b)->a+b);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0};
        CountRangeSum countRangeSum = new CountRangeSum();
        countRangeSum.countRangeSum(nums, 0, 0);
    }

}
