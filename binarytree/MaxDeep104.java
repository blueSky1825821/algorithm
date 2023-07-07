package binarytree;

import java.util.LinkedList;

public class MaxDeep104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
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
}
