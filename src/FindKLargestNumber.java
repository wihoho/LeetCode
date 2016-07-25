/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 30/6/2016.
 */
public class FindKLargestNumber {
    public static void main(String[] args) {
        FindKLargestNumber findKLargestNumber = new FindKLargestNumber();
        int[] nums = {2, 1};
        System.out.println(findKLargestNumber.findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int size = nums.length;

        if (k < 1 || k > size) return -1;

        int start = 0;
        int end = size - 1;

        while (start < end) {
            int temp = partition(nums, start, end);
            if (temp == k - 1) return nums[temp];
            else if (temp < k - 1) start = temp + 1;
            else end = temp - 1;
        }

        return nums[k - 1];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];

        int i = start + 1;
        int j = end;

        while (true) {
            while (i <= end && nums[i] > pivot) {
                i++;
            }

            while (j >= start && nums[j] <= pivot) {
                j--;
            }

            if (i >= j || i == end + 1 || j == start - 1) {
                break;
            }

            swap(nums, i, j);
        }

        if (j >= start) {
            swap(nums, start, j);
            return j;
        } else {
            return start;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
