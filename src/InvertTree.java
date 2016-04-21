/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/4/2016.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;

        return root;
    }
}
