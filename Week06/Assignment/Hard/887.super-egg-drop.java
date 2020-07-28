/*
 * @lc app=leetcode id=887 lang=java
 *
 * [887] Super Egg Drop
 */

// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        //dp[k][m] represent the maximum number of floors we can get when we have k eggs with m moves (m chances)
        //dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        //base case: dp[k][0] = 0, dp[0][m] = 0

        int[][] dp = new int[K + 1][N + 1]; // when we have only one eggs, we need N chances to get N floors

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k - 1][m - 1] + 1 + dp[k][m - 1];
            }
        }
        return m;
    }
}
// @lc code=end

