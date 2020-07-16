/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        //dp[i] means if we jump from i-th, the cost we need. 
        //Therefore, the result should be min(dp[i - 1], dp[i - 2]) because we can get i from (i-1) or (i-2)
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);

    }
}
// @lc code=end

