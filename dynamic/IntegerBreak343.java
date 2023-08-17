package dynamic;

public class IntegerBreak343 {
    public IntegerBreak343() {
        System.out.println("init");
    }
    public int integerBreak(int n) {
        //dp[i] 拆分的最大值
        //dp[i] = Math.max(j * dp[i-j], j * (i-j))
        //dp[0]=0;dp[1]=0;dp[2]=1
        //i => 1 - n
        //dp[2] = 1 * 1;dp[3]=1*2;dp[10]=3*3*4
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                System.out.println("dp[" + i + "]:" + dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("start");
        int i = new IntegerBreak343().integerBreak(10);
        System.out.println(i);
    }
}
