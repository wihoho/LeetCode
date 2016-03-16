import java.util.Arrays;
import java.util.List;

/**
 * Created by wihoho on 15/3/16.
 */
public class FlatBST {

    public void flatten(TreeNode root) {
        flattern(root);
    }

    public List<TreeNode> flattern(TreeNode root) {
        if (root == null) {
            return Arrays.asList(null, null);
        }

        if (root.left != null) {
            List<TreeNode> nodes = flattern(root.left);

            TreeNode temp = root.right;
            root.right = nodes.get(0);

            if (nodes.get(1) != null) {
                nodes.get(1).right = temp;
            }

            root.left = null;

            if (temp !=null) {
                List<TreeNode> more = flattern(temp);

                return Arrays.asList(root, more.get(1));
            } else {
                return Arrays.asList(root, nodes.get(1));
            }
        } else if (root.right != null){
            List<TreeNode> more1 = flattern(root.right);
            return Arrays.asList(root, more1.get(1));
        } else {
            return Arrays.asList(root, root);
        }
    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        two.left = three;
        three.left = four;
        four.right = five;
        five.right = six;

        FlatBST flatBST = new FlatBST();
        flatBST.flatten(one);
        System.out.println();

    }
}
