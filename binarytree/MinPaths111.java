package binarytree;

/**
 * DESCRIPTION:
 * <P>
 *
 * </p>
 *
 * @author wangmin
 * @since 2023/7/7 17:48
 */
public class MinPaths111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return visit(root);
    }

    public int visit(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right == null) {
            return 0;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

}
