package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTree617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i = i + 2) {
                TreeNode node1 = queue.remove();
                TreeNode node2 = queue.remove();
                node1.val = node1.val + node2.val;
                if (node1.left != null && node2.left != null) {
                    queue.offer(node1.left);
                    queue.offer(node2.left);
                }
                if (node1.right != null && node2.right != null) {
                    queue.offer(node1.right);
                    queue.offer(node2.right);
                }
                if (node1.left == null && node2.left != null) {
                    node1.left = node2.left;
                }
                if (node1.right == null && node2.right != null) {
                    node1.right = node2.right;
                }
            }
        }

        return root1;
    }
}
