/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        //initially, the start point is 0. 
        int start = 0;
        //The upper bound should be 1 because only the first point is availble at first.
        int end = 1;
        
        while (end < nums.length) {

            int maxLength = 0;
            for (int i = start; i < end; i++) {
                //find the maximum length from the start point to end point
                maxLength = Math.max(maxLength, i + nums[i]);
            }
            //could be the minimum length of last jump, could just be the 'end' last time
            start = end;
            //the maximum length of last jump
            end = maxLength + 1;
            count++;
        }
        return count;
    }
}
// @lc code=end

