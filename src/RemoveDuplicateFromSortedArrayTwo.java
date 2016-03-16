/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 3/3/2016.
 */
public class RemoveDuplicateFromSortedArrayTwo {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int size = nums.length;

        if (size <= 2) return size;

        int total = 2;
        int start = 2;
        while (start < size) {
            if (nums[start] != nums[total-2]) nums[total++] = nums[start];
            start ++;
        }

        return total;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArrayTwo removeDuplicateFromSortedArrayTwo = new RemoveDuplicateFromSortedArrayTwo();
        int[] nums = {1,1,1,2,2,3};
        int result = removeDuplicateFromSortedArrayTwo.removeDuplicates(nums);
        System.out.println();
    }
}
