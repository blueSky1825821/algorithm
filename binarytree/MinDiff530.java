package binarytree;

import java.util.ArrayList;
import java.util.List;

public class MinDiff530 {
    public int getMinimumDifference(TreeNode root) {
        result.clear();
        traversal(root);
        if (result.size() < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) - result.get(i - 1) < min) {
                min = result.get(i) - result.get(i - 1);
            }
        }
        return min;
    }

    List<Integer> result = new ArrayList<>();

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }

    public static void main(String[] args) {
        int minimumDifference = new MinDiff530().getMinimumDifference(ConvertArray2TreeNode.convert(new Integer[]{1, 0, 48, null, null, 12, 49}));
        System.out.println(minimumDifference);
    }
}
