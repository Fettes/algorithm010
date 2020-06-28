/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return Pow(x, power);
    }
    public double Pow(double x, long power) {
        if (power == 0) {
            return 1;
        }
        double part = Pow(x, power / 2);
        if (power % 2 == 0) {
            return part * part;
        } else {
            return part * part * x;
        }
    }
}
// @lc code=end

