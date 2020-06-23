/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    public int helper(int[] nums, int low, int high) {
        int[] newArr = Arrays.copyOfRange(nums, low, high + 1);
        int[] dp = new int[newArr.length + 1];

        if(newArr.length == 0) return 0;
        if(newArr.length == 1) return newArr[0];

        dp[0] = 0;
        dp[1] = newArr[0];

        for (int i = 2; i <= newArr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + newArr[i - 1]);
        }
        return dp[newArr.length];
    }
}
// @lc code=end

