import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/4/2016.
 */
public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, result, new ArrayList<>());
        return result;
    }

    public void binaryTreePaths(TreeNode root, List<String> result, List<Integer> runner) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            runner.add(root.val);
            result.add(convert(runner));
            runner.remove(runner.size() - 1);
            return;
        }

        runner.add(root.val);
        if (root.left != null) {
            binaryTreePaths(root.left, result, runner);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, result, runner);
        }
        runner.remove(runner.size() - 1);
    }

    private String convert(List<Integer> input) {
        if (input.isEmpty()) return "";

        StringBuffer sb = new StringBuffer();
        sb.append(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            sb.append("->");
            sb.append(input.get(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;

        BinaryTreePath binaryTreePath = new BinaryTreePath();
        List<String> result = binaryTreePath.binaryTreePaths(treeNode1);
        System.out.printf("");


    }

}
