/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String curr = "";
        int left = 0;
        int right = 0;
        helper(left, right, n, curr, res);
        return res;
    }
    public void helper(int left, int right, int length, String curr, List<String> res) {
        //Terminator
        if (left == length && right == length) {
            res.add(curr);
            return;
        }
        //Process
        if (left < length) {
            String s1 = curr + "(";
            helper(left + 1, right, length, s1, res);
        }
        if (right < left) {
            String s2 = curr + ")";
            helper(left, right + 1, length, s2, res);
        }
    }  
}
// @lc code=end

