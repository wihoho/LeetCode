/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 22/6/2016.
 */
public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inOrder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        two.left = three;
        two.right = one;

        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(two);
        System.out.println();
    }


}
