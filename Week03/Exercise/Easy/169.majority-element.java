/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length / 2;
        Arrays.sort(nums);
        int count = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > size) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
// @lc code=end

