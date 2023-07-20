package greedy;

public class CanJump55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            //nums[maxIndex] - (i - maxIndex) 表 maxIndex的最大剩余步数
            if (nums[i] > nums[maxIndex] - (i - maxIndex)) {
                maxIndex = i;
            }
            //最大步数可以直接走到最后
            if (nums[maxIndex] + maxIndex >= nums.length - 1) {
                return true;
            }
            //最大剩余步数为0
            if (nums[maxIndex] - (i - maxIndex) == 0) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new CanJump55().canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
    }

}
