import java.util.ArrayList;
import java.util.List;

/**
 * Created by GongLi on 1/6/15.
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(arr, 8));
    }

    public static int[] searchRange(int[] nums, int target) {
        int position = binarySearch(nums, target, 0, nums.length - 1);
        if (position == -1)
            return new int[]{-1, -1};

        List<Integer> result = new ArrayList<Integer>();

        int i = position;
        while (i >= 0 && nums[i] == target) {
            result.add(i);
            i--;
        }

        int j = position;
        while (j <= nums.length - 1 && nums[j] == target) {
            result.add(j);
            j++;
        }

        int[] resultA = new int[2];
        resultA[0] = i + 1;
        resultA[1] = j - 1;

        return resultA;


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

        }

        return -1;

    }
}
