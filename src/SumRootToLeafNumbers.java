import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 17/3/2016.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int[] value = new int[1];
        sumNumbers(root, value, new ArrayList<>());
        return value[0];
    }

    public void sumNumbers(TreeNode root, int[] value, List<Integer> current) {
        ;
        current.add(root.val);
        if (root.left == null && root.right == null) {
            value[0] += convert(current);
        } else {
            if (root.left != null) {
                sumNumbers(root.left, value, current);
            }

            if (root.right != null) {
                sumNumbers(root.right, value, current);
            }
        }
        if (!current.isEmpty())
            current.remove(current.size() - 1);
    }

    public int convert(List<Integer> list) {
        int sum = 0;
        int temp = 1;

        for (int i = list.size() - 1; i >= 0; i--) {
            sum += temp * list.get(i);
            temp *= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        treeNode.left = left;
        TreeNode right = new TreeNode(2);
        treeNode.right = right;
        System.out.println(sumRootToLeafNumbers.sumNumbers(treeNode));
    }
}
