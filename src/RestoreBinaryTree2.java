/**
 * Created by wihoho on 14/3/16.
 */
public class RestoreBinaryTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart <= inEnd) {

            int rootValue = postorder[postEnd];

            int position = inStart;
            for (; position <= inEnd; position++) {
                if (inorder[position] == rootValue) break;
            }

            if (position > inEnd) return null;

            TreeNode left = buildTree(inorder, inStart, position - 1, postorder, postStart, position - 1 - inStart + postStart);
            TreeNode right = buildTree(inorder, position + 1, inEnd, postorder, position - inStart + postStart, postEnd - 1);

            TreeNode root = new TreeNode(rootValue);
            root.left = left;
            root.right = right;

            return root;
        } else {
            return null;
        }

    }

}
