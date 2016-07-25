/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/7/2016.
 */
public class HouseRobberThree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.right = d;

        HouseRobberThree houseRobberThree = new HouseRobberThree();
        System.out.println(houseRobberThree.rob(a));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return root.val;

        int can1 = rob(root.left) + rob(root.right);

        int can2 = 0;
        if (root.left != null) {
            can2 += rob(root.left.left);
            can2 += rob(root.left.right);
        }

        if (root.right != null) {
            can2 += rob(root.right.left);
            can2 += rob(root.right.right);
        }

        return can1 > can2 ? can1 : can2;
    }
}
