/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/3/2016.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;


        int start = 1;
        int end = nums.length - 2;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[middle + 1] && nums[middle] > nums[middle - 1]) return middle;

            if (nums[middle - 1] > nums[middle]) {
                end = middle - 1;
                continue;
            }

            if (nums[middle + 1] > nums[middle]) {
                start = middle + 1;
                continue;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement findPeakElement = new FindPeakElement();
        int result = findPeakElement.findPeakElement(nums);
        System.out.println();
    }

}
