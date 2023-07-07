package binarytree;

import java.util.List;

public class BinaryTreeTraversal {
    public void preTraversal(TreeNodeB root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preTraversal(root.right, result);
        preTraversal(root.left, result);
    }

    public void middleTraversal(TreeNodeB root, List<Integer> result) {
        if (root == null) {
            return;
        }
        middleTraversal(root.left, result);
        result.add(root.value);
        middleTraversal(root.right, result);
    }

    public void afterTraversal(TreeNodeB root, List<Integer> result) {
        if (root == null) {
            return;
        }
        afterTraversal(root.left, result);
        afterTraversal(root.right, result);
        result.add(root.value);
    }
}
