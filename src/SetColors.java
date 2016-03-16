/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 2/3/2016.
 */
public class SetColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int size = nums.length;

        int one = -1;
        int two = -1;
        for(int i = 0; i < size; i ++) {
            switch (nums[i]) {
                case 0:
                    swap(nums, i, two + 1);
                    swap(nums, one+1, two + 1);
                    one ++;
                    two++;

                    break;
                case 1:
                    swap(nums, i, two + 1);
                    two ++;
                    break;
                case 2:
                    continue;
            }
        }

    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        SetColors setColors = new SetColors();
        int[] nums = {0,1};
        setColors.sortColors(nums);
        System.out.println();

    }
}
