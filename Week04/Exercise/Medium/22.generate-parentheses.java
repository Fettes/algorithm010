import java.awt.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        int left = 0;
        int right = 0;
        String curr = "";
        helper(left, right, n, curr, result);
        return result;
    }
    public void helper(int left, int right, int n, String curr, List<String> result) {
        if (left == n && right == n) {
            result.add(curr);
            return;
        }
        if (left < n) {
            helper(left + 1, right, n, curr + "(", result);
        }
        if (right < left) {
            helper(left, right + 1, n, curr + ")", result);
        }
    }
}
// @lc code=end

