package binarytree;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/10 15:48
 */
public class MaxTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int begin = 0;
        int end = nums.length - 1;
        return traversal(nums, begin, end);
    }

    public TreeNode traversal(int[] nums, int begin, int end) {
        int index = maxIndex(nums, begin, end);
        if (index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        System.out.println("maxValue:" + root.val);
        root.left = traversal(nums, begin, index - 1);
        root.right = traversal(nums, index + 1, end);
        return root;
    }


    public int maxIndex(int[] nums, int begin, int end) {
        if (nums.length == 0) {
            return -1;
        }
        if (begin > nums.length - 1 || end > nums.length -1 || begin > end) {
            return -1;
        }
        int index = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        System.out.println("max:" + index);
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = new MaxTree654().constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }
}
