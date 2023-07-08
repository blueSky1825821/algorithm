package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertArray2TreeNode {

    public static TreeNode convert(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        //1 为 null
        int leftNullFlag = 0;
        for (int i = 1; i < array.length; i++) {
            TreeNode parentNode = deque.removeFirst();
            if (array[i] != null) {
                TreeNode childNode = new TreeNode(array[i]);
                deque.addLast(childNode);
                //左节点已经赋值
                if (parentNode.left != null || (leftNullFlag == 1)) {
                    parentNode.right = childNode;
                    leftNullFlag = 0;
                    //左节点没有赋值
                } else {
                    //处理的是左节点 还需要放入队列再处理右节点
                    parentNode.left = childNode;
                    deque.addFirst(parentNode);
                }
            } else {
                //左节点已经赋值
                if (parentNode.left != null || (leftNullFlag == 1)) {
                    leftNullFlag = 0;
                    //左节点没有赋值
                } else {
                    //处理的是左节点 还需要放入队列再处理右节点
                    leftNullFlag = 1;
                    deque.addFirst(parentNode);
                }
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
        TreeNode visit = convert(array);
        System.out.println(visit);
    }
}
