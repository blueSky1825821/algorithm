package binarytree;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/12 17:40
 */
public class LowestCommonAncestor236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else { //  (left == NULL && right == NULL)
            return null;
        }
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
    }
}
