package binarytree;

/**
 * DESCRIPTION:
 * <P>
 *     左右中 后序遍历
 * </p>
 *
 * @author wangmin
 * @since 2023/7/13 10:00
 */
public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
