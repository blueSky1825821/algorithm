package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {
    public void preTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preTraversal(root.right, result);
        preTraversal(root.left, result);
    }

    public void middleTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        middleTraversal(root.left, result);
        result.add(root.val);
        middleTraversal(root.right, result);
    }

    public void afterTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        afterTraversal(root.left, result);
        afterTraversal(root.right, result);
        result.add(root.val);
    }

    /**
     * 层级访问
     */
    public List<Integer> levelTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
