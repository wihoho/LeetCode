public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int m = i; m <= j; m++) {
            sum += nums[m];
        }

        return sum;
    }
}