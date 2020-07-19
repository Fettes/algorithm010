/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;

        //count the left parentheses
        int leftPar = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftPar++;
            } else if (leftPar > 0) {
                dp[i] = dp[i - 1] + 2;
                // add the previous number of parantheses
                dp[i] += (i - dp[i]) > 0 ? dp[i - dp[i]] : 0;
                leftPar--;
                result = Math.max(dp[i], result);
            }
        }
        return result;
    }
}
// @lc code=end

