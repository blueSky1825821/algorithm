package binarytree;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/10 13:51
 */
public class NodeStatistic222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{1, 2, 3, null, 5});
        int count = new NodeStatistic222().countNodes(root);
        System.out.println(count);
    }
}
