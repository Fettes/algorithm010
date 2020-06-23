/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] curr = new int[nums.length + 1];
        curr[0] = 0;
        curr[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            curr[i] = Math.max(curr[i - 1], curr[i - 2] + nums[i - 1]);
        }
        return curr[nums.length];
    }
}
// @lc code=end

