import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 15/3/16.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, int cur, List<Integer> list, List<List<Integer>> result) {
        if (root == null) return;

        cur += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (cur == sum) {
                result.add(new ArrayList<>(list));
            }

            return;
        }

        if (root.left != null) {
            pathSum(root.left, sum, cur, list, result);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            pathSum(root.right, sum, cur, list, result);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.right = right;

        PathSumII pathSumII = new PathSumII();
        pathSumII.pathSum(root, -5);
    }
}
