/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        //Remove the empty bar
        int begin = 0;
        while (begin < height.length && height[begin] == 0) {
            begin++;
        }
        //Based on the idea of histogram, check problem 84.
        for (int i = begin; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (!stack.isEmpty()) {
                    //choose the minimum between left bound and right bound
                    int width = i - stack.peek() - 1;
                    result += Math.min(height[stack.peek()] - bottom, height[i] - bottom) * width;
                }
            }
            stack.push(i);
        }
        return result;
    
    }
}
// @lc code=end

