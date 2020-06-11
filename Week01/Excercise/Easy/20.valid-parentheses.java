/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else if (stack.isEmpty()) {
                return false;
            }
            if (c == ')' && stack.removeLast() != '(') {
                return false;
            }
            if (c == ']' && stack.removeLast() != '[') {
                return false;
            }
            if (c == '}' && stack.removeLast() != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

