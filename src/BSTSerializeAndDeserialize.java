import java.util.StringTokenizer;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/5/2016.
 */
public class BSTSerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val+" ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer stringTokenizer = new StringTokenizer(data," ");
        return deserializeHelper(stringTokenizer);
    }

    private TreeNode deserializeHelper(StringTokenizer stringTokenizer) {
        if (!stringTokenizer.hasMoreElements()) {
            return null;
        }

        String currentItem = stringTokenizer.nextToken();
        if (currentItem.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(currentItem));
        TreeNode left = deserializeHelper(stringTokenizer);
        TreeNode right = deserializeHelper(stringTokenizer);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        BSTSerializeAndDeserialize bstSerializeAndDeserialize = new BSTSerializeAndDeserialize();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        String result = bstSerializeAndDeserialize.serialize(n1);

        TreeNode treeNode = bstSerializeAndDeserialize.deserialize(result);
        System.out.println();
    }
}
