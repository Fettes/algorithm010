/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (nums.length == 0 || k == 0) {
            return result;
        }

        Deque<Integer> window = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //Romove the elements that are out of left bound
            while (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.removeFirst();
            }
            //Remove the elements that are smaller than the comming element
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.removeLast();
            }
            //Add the current element
            window.addLast(i);
            //The left most element should be the maximum
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[window.peekFirst()];
            }                
        }
        return result;
    }
}
// @lc code=end

