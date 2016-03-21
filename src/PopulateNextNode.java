import java.util.ArrayList;
import java.util.List;

/**
 * Created by wihoho on 15/3/16.
 */
public class PopulateNextNode {

    public void connect(TreeLinkNode root) {

        if (root == null) return;

        List<TreeLinkNode> cur = new ArrayList<>();
        cur.add(root);

        while (!cur.isEmpty()) {

            for(int i = 0; i < cur.size() -1; i ++) {
                cur.get(i).next = cur.get(i+1);
            }

            List<TreeLinkNode> next = new ArrayList<>();
            for(TreeLinkNode n:cur) {
                if (n.left !=null) {
                    next.add(n.left);
                }

                if (n.right != null) {
                    next.add(n.right);
                }
            }

            cur = next;
        }

    }


}
