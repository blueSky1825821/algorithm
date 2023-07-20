package greedy;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    //贪心
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }


        public static void main(String[] args) {
        int i = new MaxSubArray53().maxSubArray2(new int[]{1, -3, 5});
        System.out.println(i);
    }
}
