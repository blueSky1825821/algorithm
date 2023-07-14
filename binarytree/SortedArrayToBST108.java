package binarytree;

public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int begin, int end) {
        if (end - begin < 0) {
            return null;
        }

        int middle = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[middle]);

        root.left = traversal(nums, begin, middle - 1);
        root.right = traversal(nums, middle + 1, end);
        return root;
    }

}
