package dynamic;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/27 17:51
 */
public class ClimbStairs70 {
    public int climbStairs(int n) {
        // step1: dp[i] n种方法
        // step2: dp[i] = dp[i-1] + dp[i-2] 爬到 i-1 i-2的方法
        // step3: dp[0] = 0;dp[1] = 1;dp[2] = 2;
        // step4: 0 -> n
        // step5: dp[2]=2 dp[3]=3
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println("dp[" + i + "]:" + dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int fib = new ClimbStairs70().climbStairs(4);
        System.out.println(fib);
    }
}
