/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/6/2016.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int size = nums.length;

        k %= size;
        swap(nums, 0, size - k - 1);
        swap(nums, size - k, size - 1);
        swap(nums, 0, size - 1);
    }

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] nusm = {1,2,3,4,5,6,7};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nusm, 3);
        System.out.println();
    }
}
