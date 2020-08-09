/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();

        if (s.length() == 0) {
            return count;
        }
        
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (s.charAt(i) == ' ') {
                count = 0;
            }
        }

        return count;
    }
}
// @lc code=end

