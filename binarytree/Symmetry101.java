package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class Symmetry101 {

    public static boolean visit(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.removeFirst();
            TreeNode right = deque.removeLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            deque.addFirst(left.left);
            deque.addLast(right.right);
            deque.addFirst(left.right);
            deque.addLast(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(visit(root));
    }
}
