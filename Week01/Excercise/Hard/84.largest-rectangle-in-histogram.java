/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Initialize a stack to save the index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            /*
            As we know, the limitation is the smaller height bar.
            Thus, when we encounter a smaller height, we try to pop all the bars whose height is larger.
            By doing so, the stack may be maintained as a increasingly stack.
            */
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }

        // Now, the number in stacks are in increasing order.
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxArea;
    }
}
// @lc code=end

