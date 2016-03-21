import javax.swing.tree.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wihoho on 11/3/16.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> currentLevel = new ArrayList<>();
        if (root != null) {
            currentLevel.add(root);
        }

        while (!currentLevel.isEmpty()) {
            List<Integer> cur = currentLevel.stream().map(item -> item.val).collect(Collectors.toList());
            result.add(cur);

            List<TreeNode> nextLevel = new ArrayList<>();
            currentLevel.forEach(
                    item -> {
                        if (item.left != null) {
                            nextLevel.add(item.left);
                        }

                        if (item.right != null) {
                            nextLevel.add(item.right);
                        }
                    }
            );

            currentLevel = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
