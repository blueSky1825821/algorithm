package binarytree;

import java.util.List;

public class BalanceBinaryTree110 {

    //[1,2,3,4,5,6,null,8]
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, null, 8};
        TreeNode root = ConvertArray2TreeNode.convert(array);
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

    public boolean isBalanced(TreeNode root) {
        int diff = getHeight(root);
        return diff != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        System.out.println("node:" + root.value + " leftHeight:" + leftHeight);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        System.out.println("node:" + root.value + " rightHeight:" + rightHeight);
        if (rightHeight == -1) {
            return -1;
        }
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
