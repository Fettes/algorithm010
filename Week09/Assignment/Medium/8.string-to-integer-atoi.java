/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        long result = 0;

        //step1: remove spaces
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        //step2: empty string
        if (index == str.length()) {
            return 0;
        }

        //step3: check the sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //step4: get the final number
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            result = result * 10 + digit;
            //check the overflow
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            index++;
        }
        return (int)result * sign;
    }
}
// @lc code=end

