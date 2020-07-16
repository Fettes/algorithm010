/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        //Main idea: save the max absolute value of each production
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                //when multiple with a minus number, the minimum is the maximum absolute number
                int temp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], temp * nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;  
    }
}
// @lc code=end

