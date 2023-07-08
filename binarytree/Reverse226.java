package binarytree;

public class Reverse226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode treeNode = new Reverse226().invertTree(root);
        System.out.println(treeNode);
    }
}
