/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/3/2016.
 */
public class MinTreeDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0) {
            return 1 + right;
        } else if (right == 0) {
            return 1 +left;
        } else {
            return 1 + Math.min(left, right);
        }
    }

    public static void main(String[] args) {

    }
}
