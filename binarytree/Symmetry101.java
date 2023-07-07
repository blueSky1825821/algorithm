package binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Symmetry101 {

    public static boolean visit(TreeNodeB root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNodeB> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNodeB left = deque.removeFirst();
            TreeNodeB right = deque.removeLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || !Objects.equals(left.value, right.value)) {
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
        TreeNodeB root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(visit(root));
    }
}
