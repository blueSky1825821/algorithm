package binarytree;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/13 10:16
 */
public class DeleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null && root.right != null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else { //left != null && right != null
                TreeNode move = root.left;
                TreeNode iterator = root.right;
                while (iterator.left != null) {
                    iterator = iterator.left;
                }
                iterator.left = move;
                root = root.right;
            }
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
