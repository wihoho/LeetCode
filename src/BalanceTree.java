/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 15/3/2016.
 */
public class BalanceTree {
      public boolean isBalanced(TreeNode root) {
        int height = height(root);
        if (height == -1) return false;
        return true;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.right = two;
        two.right = three;

        BalanceTree balanceTree = new BalanceTree();
        System.out.println(balanceTree.isBalanced(one));

    }
}
