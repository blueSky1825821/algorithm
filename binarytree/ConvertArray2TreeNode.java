package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertArray2TreeNode {
    public static TreeNode visit(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        for (int i = 1; i < array.length; i++) {
            TreeNode node = deque.peek();
            if (node == null) {
                return root;
            }
            //优先填充left
            if (node.left == null) {
                node.left = new TreeNode(array[i]);
                deque.add(node.left);
                //left不为空，说明left有值，才能填充right
            } else if (node.right == null) {
                node.right = new TreeNode(array[i]);
                deque.add(node.right);
                deque.remove();
            }
        }
        return root;
    }

    //获取数组满二叉树总层数
    public static int acquireLevel(Integer[] array) {
        if (array.length == 0) {
            return 0;
        }
        int level = 1;
        int levelTotal = 1;
        while (levelTotal < array.length) {
            levelTotal += 1 << level;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, null, 8};
        System.out.println(acquireLevel(array));
        TreeNode visit = visit(array);
        System.out.println(visit);
    }
}
