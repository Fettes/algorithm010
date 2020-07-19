/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    //when row is reaching bound
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    //when column is reaching bound
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i == m - 1 && j == n - 1) {
                    //the start point
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1]; 
    }
}
// @lc code=end

