/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l2 + 1][l1 + 1];

        for (int i = 0; i <= l1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= l2; i++) {
            for (int j = 1; j <= l1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[l2][l1];
    }
}
// @lc code=end

