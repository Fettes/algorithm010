/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];
        //Base case1: only 1 character which is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //Base case2 with dp function
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (length == 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
            }
        }

        //count
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

