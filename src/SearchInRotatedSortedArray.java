/**
 * Created by GongLi on 1/6/15.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = {3, 1};
        System.out.println(search(arr, 1));
    }

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }


    public static int search(int[] nums, int low, int high, int target) {
        if (low <= high) {

            int middle = (low + high) / 2;
            if (nums[middle] == target)
                return middle;

            else if (nums[low] <= nums[middle]) {
                if (target >= nums[low] && target < nums[middle]) {
                    return search(nums, low, middle - 1, target);
                } else {
                    return search(nums, middle + 1, high, target);
                }
            } else {
                if (target > nums[middle] && target <= nums[high]) {
                    return search(nums, middle + 1, high, target);

                } else {
                    return search(nums, low, middle - 1, target);
                }
            }
        }

        return -1;

    }

}
