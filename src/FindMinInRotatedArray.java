/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 24/3/2016.
 */
public class FindMinInRotatedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] min = new int[1];
        min[0] = nums[0];

        findMin(nums, 0, nums.length - 1, min);
        return min[0];
    }

    public void findMin(int[] nums, int start, int end, int[] min) {
        while (start < end - 1) {
            if (nums[start] == nums[start + 1]) {
                start++;
            } else {
                break;
            }
        }

        while (end > start + 1) {
            if (nums[end] == nums[end - 1]) {
                end--;
            } else {
                break;
            }
        }


        if (start == end) {
            min[0] = min[0] > nums[start] ? nums[start] : min[0];
        } else if (start < end) {
            int middle = (start + end) / 2;
            if (nums[start] <= nums[middle]) {
                min[0] = min[0] > nums[start] ? nums[start] : min[0];
                findMin(nums, middle + 1, end, min);
            }

            if (nums[middle] <= nums[end]) {
                min[0] = min[0] > nums[middle] ? nums[middle] : min[0];
                findMin(nums, start, middle - 1, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 1};
        FindMinInRotatedArray findMinInRotatedArray = new FindMinInRotatedArray();
        int result = findMinInRotatedArray.findMin(nums);
        System.out.println();
    }
}
