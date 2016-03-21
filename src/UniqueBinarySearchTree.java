import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 13/3/16.
 */
public class UniqueBinarySearchTree {

    public static void main(String[] args) {
        UniqueBinarySearchTree uniqueBinarySearchTrees = new UniqueBinarySearchTree();
        uniqueBinarySearchTrees.generateTrees(2);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        if (start == end) {
            TreeNode node = new TreeNode(start);
            List<TreeNode> lst = new ArrayList<>();
            lst.add(node);
            return lst;
        }

        List<TreeNode> result = new ArrayList<>();
        for(int i = start; i <= end; i ++) {
            List<TreeNode> left = generateTrees(start, i);
            List<TreeNode> right = generateTrees(i, end);

            TreeNode cur = new TreeNode(i);

            for(TreeNode l : left) {
                for (TreeNode r: right) {
                    cur.left = l;
                    cur.right = r;

                    result.add(cur);
                }
            }
        }

        return result;
    }
}
