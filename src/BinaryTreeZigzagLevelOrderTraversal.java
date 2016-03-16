import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wihoho on 11/3/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> currentLevel = new ArrayList<>();
        if (root != null) {
            currentLevel.add(root);
        }

        boolean left = false;
        while (!currentLevel.isEmpty()) {
            List<Integer> cur = currentLevel.stream().map(item -> item.val).collect(Collectors.toList());
            result.add(cur);

            List<TreeNode> nextLevel = new ArrayList<>();


            if (left) {

                for(int i = 0; i < currentLevel.size(); i ++) {
                    TreeNode curNode = currentLevel.get(i);
                    if (curNode.left != null) {
                        nextLevel.add(curNode.left);
                    }

                    if (curNode.right != null) {
                        nextLevel.add(curNode.right);
                    }
                }

                left = false;


            } else {

                for(int i = currentLevel.size() - 1; i >= 0; i --) {
                    TreeNode curNode = currentLevel.get(i);

                    if (curNode.right != null) {
                        nextLevel.add(curNode.right);
                    }

                    if (curNode.left != null) {
                        nextLevel.add(curNode.left);
                    }


                }

                left = true;
            }

            currentLevel = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
