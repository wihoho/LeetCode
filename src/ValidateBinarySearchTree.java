import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/3/2016.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = getInOrderSequence(root);
        for(int i = 1; i < result.size(); i ++) {
            if (result.get(i-1) >= result.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    public List<Integer> getInOrderSequence(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        inOrder(node, result);
        return result;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode one = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        one.left = left;

        System.out.println( validateBinarySearchTree.isValidBST(one));
    }
}
