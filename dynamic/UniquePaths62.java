package dynamic;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j] 有几条路径
        //dp[i][j]=dp[i-1][j] + dp[i][j-1]
        //dp[0][0]=1 dp[i][0]=1 dp[0][j]=1
        //正向
        //dp[2][2]=2
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.println("dp[" + i + "]:" + dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int i = new UniquePaths62().uniquePaths(2, 3);
        System.out.println(i);
    }
}
