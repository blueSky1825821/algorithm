package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        } else if (root.right == null && root.left != null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 3, null, 5});
        int min = minDepth(root);
        System.out.println(min);
        root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, null, 4});
        min = minDepth(root);
        System.out.println(min);
    }
}
