/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) {
            return 0;
        }

        int n = triangle.size();
        int[][] dp = new int[n][n];
        //initialization
        dp[0][0] = triangle.get(0).get(0);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        //find the minimum in the last row
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }
}
// @lc code=end

