/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 6/5/2016.
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int end = 0;
        int start = 1;

        while (start < nums.length) {
            if (nums[start] == 0 ) {
                if (nums[end] != 0) {
                    end = start;
                }

            } else {
                if (nums[end] == 0) {
                    change(nums, start, end);
                    end++;
                }

            }

            start++;
        }
    }

    public void change(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 3, 12};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(nums);
        System.out.println(nums);

    }


}
