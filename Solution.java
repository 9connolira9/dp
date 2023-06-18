package 动规;

public class Solution {
    public static void main(String[] args) {

    }

    /*
        斐波那契数
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        //第i个数的斐波那契数值是dp[i]
        int[] dp = new int[n + 1];
        //dp数组如何初始化
        dp[0] = 0;
        dp[1] = 1;
        //确定遍历顺序
        for (int i = 2; i <= n; i++) {
            //状态转移方程 dp[i] = dp[i - 1] + dp[i - 2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*
        爬楼梯
     */
    public int climbStairs(int n) {
        //dp[i]表示第i层有几种
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*
        不同路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //dp数组初始化
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    /*
        不同路径II
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //dp数组初始化
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    /*
        整数拆分
     */

}
