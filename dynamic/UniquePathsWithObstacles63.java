package dynamic;

public class UniquePathsWithObstacles63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j] 多少条路径
        //dp[i][j] = dp[i-1][j] + dp[i][j-1]
        //dp[0][j] = 0;dp[i][0] = 0
        //0->i;0->j
        //dp[i][j]
        if (obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //obstacleGrid[i][0] == 0 后面不赋值
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
            //这里会导致obstacleGrid[0][j+1] 赋值
//            if (obstacleGrid[0][j] == 1) {
//                dp[0][j] = 0;
//            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                System.out.println("dp[" + i + "]" + "[" + j + "]:" + dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int i = new UniquePathsWithObstacles63().uniquePathsWithObstacles(new int[][]{{1, 0}, {0, 0}});
        System.out.println(i);
    }
}
