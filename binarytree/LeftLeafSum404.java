package binarytree;

import java.util.Stack;

public class LeftLeafSum404 {
    Stack<Boolean> leftFlags = new Stack<>();
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        leftFlags.add(false);
        visit(root);
        return sum;
    }

    public void visit(TreeNode root) {
        //说明是左叶子
        if (leftFlags.peek() && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        //处理左节点
        if (root.left != null) {
            leftFlags.push(true);
            visit(root.left);
            leftFlags.pop();
        }
        //处理右节点
        if (root.right != null){
            leftFlags.push(false);
            visit(root.right);
            leftFlags.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = ConvertArray2TreeNode.convert(new Integer[]{3,9,20,null,null,15,7});
        int result = new LeftLeafSum404().sumOfLeftLeaves(root);
        System.out.println(result);
    }
}
