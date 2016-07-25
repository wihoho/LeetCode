/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/7/2016.
 */
public class CountNode {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = left(root.left);
        int right = right(root.right);
        if (left == right) {
            return (1 << (left + 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int left(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private int right(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }

    public static void main(String[] args) {
        CountNode countNode = new CountNode();
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node.left = node2;
        node.right = node3;
        System.out.println(countNode.countNodes(node));
    }
}
