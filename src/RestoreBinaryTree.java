/**
 * Created by wihoho on 14/3/16.
 */
public class RestoreBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart <= preEnd) {
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            int rootPosition = inStart;
            for (; rootPosition <= inEnd; rootPosition++) {
                if (inorder[rootPosition] == rootVal) break;
            }

            if (rootPosition == inEnd + 1) return null;

            TreeNode left = buildTree(preorder, preStart + 1, rootPosition - inStart + preStart, inorder, inStart, rootPosition - 1);
            TreeNode right = buildTree(preorder, rootPosition - inStart + preStart + 1, preEnd, inorder, rootPosition + 1, inEnd);
            root.left = left;
            root.right = right;
            return root;
        } else {
            return null;
        }
    }
}
