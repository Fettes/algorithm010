/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;

        int max = 0;
        while (low < high) {
            int minHeight = Math.min(height[low], height[high]);
            max = Math.max(max, minHeight * (high - low));
            
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
// @lc code=end

