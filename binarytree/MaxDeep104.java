package binarytree;

import java.util.LinkedList;

public class MaxDeep104 {
    int max = 0;
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return max;
        }
        maxDeep(root, new LinkedList<>());
        return max;
    }

    public void maxDeep(TreeNode root, LinkedList<Integer> paths) {
        paths.add(root.val);

        if ((root.left == null && root.right == null)) {
            System.out.println(paths.size());
            max = Math.max(max, paths.size());
            return;
        }

        if (root.left != null) {
            maxDeep(root.left, paths);
            paths.removeFirst();
        }
        if (root.right != null) {
            maxDeep(root.right, paths);
            paths.removeFirst();
        }
    }

    /**
     * 递归 需要先计算left最大深度 right最大深度 最后计算中间节点深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }
        if (root.right == null && root.left != null) {
            return leftDepth + 1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 3, null, 5});
        int depth2 = new MaxDeep104().maxDepth(root);
        System.out.println(depth2);
    }
}
