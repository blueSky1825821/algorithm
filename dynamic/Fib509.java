package dynamic;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/27 17:35
 */
public class Fib509 {
    public int fib(int n) {
        // step1: dp[i]
        // step2: dp[i] = dp[i-1] + dp[i-2]
        // step3: dp[0] = 0;dp[1] = 1;
        // step4: 0 -> n
        // step5: dp[2]=1 dp[3]=2

        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println("dp[" + i + "]:" + dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int fib = new Fib509().fib(8);
        System.out.println(fib);
    }
}
