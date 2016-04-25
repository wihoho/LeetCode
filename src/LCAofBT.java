/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/4/2016.
 */
public class LCAofBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        while (root != null) {
            if (contain(root.left, p) && contain(root.right, q)) {
                return root;
            } else if (contain(root.left, q) && contain(root.right, p)) {
                return root;
            } else if (contain(root.left, p) && contain(root.left, q)) {
                root = root.left;
            } else if (contain(root.right, p) && contain(root.right, q)) {
                root = root.right;
            } else {
                return null;
            }
        }

        return null;

    }

    public boolean contain(TreeNode root, TreeNode candidate) {
        if (root == null) return false;
        if (root == candidate) return true;
        return contain(root.left, candidate) || contain(root.right, candidate);
    }
}
