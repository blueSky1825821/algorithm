package dynamic;

import java.util.Arrays;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        //dp[i] 到达某层的最小花费
        //dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
        //dp[0]=0,dp[1]=min(dp[1]+cost[1],dp[0]+cost[0])
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            System.out.println("dp[" + i + "]:" + dp[i]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int i = new MinCostClimbingStairs746().minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(i);
    }
}
