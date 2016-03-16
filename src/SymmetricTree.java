
/**
 * Created by wihoho on 11/3/16.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
    }

    public static void main(String[] args) {

    }
}
