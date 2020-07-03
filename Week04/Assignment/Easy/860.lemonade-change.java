/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            }
            if (bills[i] == 10) {
                if (fiveNum == 0) return false;
                fiveNum--;
                tenNum++;
            }
            if (bills[i] == 20) {
                if (fiveNum > 0 && tenNum > 0) {
                    fiveNum--;
                    tenNum--;
                } else if (tenNum == 0 && fiveNum >= 3) {
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

