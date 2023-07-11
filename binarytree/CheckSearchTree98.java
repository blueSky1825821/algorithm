package binarytree;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/11 13:10
 */
public class CheckSearchTree98 {
    //中序遍历，按照遍历顺序从小到大
    long maxVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftFlag = isValidBST(root.left);
        if (!leftFlag) {
            return false;
        }
        if (maxVal < root.val) {
            maxVal = root.val;
        } else {
            return false;
        }
        boolean rightFlag = isValidBST(root.right);
        if (!rightFlag) {
            return false;
        }
        return true;
    }

    // 中序遍历后数组存放，判断数组是否从小到大
//    List<Integer> result = new ArrayList<>();
//    public boolean isValidBST(TreeNode root) {
//       traversal(root);
//       return valid(result);
//    }
//
//    public void traversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        traversal(root.left);
//        result.add(root.val);
//        traversal(root.right);
//    }
//
//    public boolean valid(List<Integer> result) {
//        if (result.size() <= 1) {
//            return true;
//        }
//        for (int i = 1; i < result.size(); i++) {
//            if (result.get(i - 1) >= result.get(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
