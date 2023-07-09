package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDeepLeftLeaf513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int value = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                //第一行第一个元素
                if (i == 0) {
                    value = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{3,9,20,null,null,15,7});
        int result = new MaxDeepLeftLeaf513().findBottomLeftValue(root);
        System.out.println(result);
    }
}
