/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int nonZero = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }
        
        for (int j = nonZero; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
// @lc code=end

