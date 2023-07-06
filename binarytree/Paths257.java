package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/6 15:51
 */
public class Paths257 {
    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 3, null, 5});
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return middleVisit(root, new ArrayList<>(), new ArrayList<>());
    }

    public static List<String> middleVisit(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.value);

        //说明是叶子节点
        if (root.left == null && root.right == null) {
            String collect = paths.stream().map(String::valueOf).collect(Collectors.joining("->"));
            System.out.println(collect);
            res.add(collect);
            return res;
        }
        if (root.left != null && root.left.value != null) {
            middleVisit(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null && root.right.value != null) {
            middleVisit(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
        return res;
    }
}
