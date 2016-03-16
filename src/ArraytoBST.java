/**
 * Created by wihoho on 14/3/16.
 */
public class ArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootPosition = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[rootPosition]);
        root.left = sortedArrayToBST(nums, start, rootPosition - 1);
        root.right = sortedArrayToBST(nums, rootPosition + 1, end);

        return root;

    }
}
