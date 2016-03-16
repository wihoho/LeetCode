import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by wihoho on 14/3/16.
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<List<Integer>> stack = new Stack<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);

        while (!cur.isEmpty()) {
            stack.add(cur.stream().map(item -> item.val).collect(Collectors.toList()));

            List<TreeNode> nextLevel = new ArrayList<>();
            cur.forEach(item -> {
                if (item.left != null) {
                    nextLevel.add(item.left);
                }

                if (item.right != null) {
                    nextLevel.add(item.right);
                }
            });

            cur = null;
            cur = nextLevel;
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
