import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 4/4/2016.
 */
public class BSTRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            result.add(nodes.get(nodes.size()-1).val);

            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode n: nodes) {
                if (n.left != null) {
                    nextLevel.add(n.left);
                }

                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }

            nodes = nextLevel;
        }

        return result;
    }


    public static void main(String[] args) {
        BSTRightView bstRightView = new BSTRightView();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three =new TreeNode(3);
        TreeNode four = new TreeNode(4);


        one.left = two;
        one.right = three;


        List<Integer> result = bstRightView.rightSideView(one);
        System.out.printf("");
    }
}
