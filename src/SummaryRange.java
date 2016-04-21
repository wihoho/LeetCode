import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/4/2016.
 */
public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev + 1 == nums[i]) {
                prev += 1;
            } else {
                if (prev == start) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + prev);
                }

                prev = nums[i];
                start = nums[i];
            }
        }

        if (prev == start) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + prev);
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRange summaryRange = new SummaryRange();
        int[] nums = {0, 1, 2, 4, 5, 6};

        List<String> result = summaryRange.summaryRanges(nums);
        System.out.printf("");
    }
}
