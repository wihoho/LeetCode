/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/3/2016.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode root, int sum, int current) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            if (current + root.val == sum) {
                return true;
            } else {
                return false;
            }
        } else if (root.left == null) {
            return hasPathSum(root.right, sum, current + root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum, current + root.val);
        } else {
            return hasPathSum(root.right, sum, current + root.val) || hasPathSum(root.left, sum, current + root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, -1));

    }
}
