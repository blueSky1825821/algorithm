package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/12 09:53
 */
public class MaxNumSearchTree501 {
    public int[] findMode(TreeNode root) {
        traversal(root);
        return maxNum.stream().mapToInt(x ->x).toArray();
    }

    int max = 0;
    List<Integer> maxNum = new ArrayList<>();
    TreeNode pre = null;
    int curSize = 0;
    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);

        if (pre == null) {
            max = 1;
            curSize = 1;
            maxNum.add(root.val);
        } else {
            if (pre.val == root.val) {
                curSize ++;
                if (curSize == max) {
                    maxNum.add(root.val);
                }
                if (curSize > max) {
                    max = curSize;
                    maxNum.clear();
                    maxNum.add(root.val);
                }
            } else {
                curSize = 1;
                if (curSize == max) {
                    maxNum.add(root.val);
                }
            }
        }
        pre = root;

        traversal(root.right);
    }
}
