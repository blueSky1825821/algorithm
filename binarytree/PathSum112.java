package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum112 {
    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        boolean flag = new PathSum112().hasPathSum(root, 22);
        System.out.println(flag);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return pathSum(root, new ArrayList<Integer>(), 0, targetSum);
    }

    public boolean pathSum(TreeNode root, List<Integer> paths, int sum, int targetSum) {
        paths.add(root.val);
        sum += root.val;

        //根节点
        if (root.left == null && root.right == null) {
            System.out.println(paths);
            return sum == targetSum;
        }

        boolean flag;
        if (root.left != null) {
            flag = pathSum(root.left, paths, sum, targetSum);
            paths.remove(paths.size() - 1);
            if (flag) {
                return true;
            }
        }
        if (root.right != null) {
            flag = pathSum(root.right, paths, sum, targetSum);
            paths.remove(paths.size() - 1);
            if (flag) {
                return true;
            }
        }
        return false;
    }

}
