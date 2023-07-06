package binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalanceBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int binaryLevelNodeNum = 1;
        int diff = 0;
        while (!queue.isEmpty()) {
            binaryLevelNodeNum = binaryLevelNodeNum * 2;
            int levelNodeNum = binaryLevelNodeNum;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    break;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    levelNodeNum--;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    levelNodeNum--;
                }
            }
            if (levelNodeNum != 0 && binaryLevelNodeNum != levelNodeNum) {
                diff ++;
            }
            if (diff > 1) {
                return false;
            }
        }

        return true;
    }
//[1,2,3,4,5,6,null,8]
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        boolean balanced = new BalanceBinaryTree110().isBalanced(root);
        System.out.println(balanced);
    }

    public void visit(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        visit(node.left, list);
        visit(node.right, list);
    }
}
