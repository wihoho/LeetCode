package Old;

/**
 * Created by GongLi on 1/6/15.
 */
public class SearchInsertPosition {


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));


    }

    public static int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);

    }


    public static int binarySearch(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target)
                return middle;

            if (target >= nums[low] && target < nums[middle]) {
                return binarySearch(nums, target, low, middle - 1);
            }

            if (target <= nums[high] && target > nums[middle])
                return binarySearch(nums, target, middle + 1, high);

            if (target > nums[high])
                return high + 1;

            if (target < nums[low])
                return low;


        }

        return low + 1;

    }
}
