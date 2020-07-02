/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long res = (long) mid * mid;

            if (num == res) {
                return true;
            } else if (res < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

