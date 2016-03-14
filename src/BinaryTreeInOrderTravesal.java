import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 10/3/2016.
 */
public class BinaryTreeInOrderTravesal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                result.add(current.val);
                root = root.right;
            }
        }

        return result;
    }


}
