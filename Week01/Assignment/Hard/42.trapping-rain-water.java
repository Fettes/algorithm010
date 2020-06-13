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
    // Top answer
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        // leftMax represents the highest bar from left
        int leftMax = Integer.MIN_VALUE;
        // rightMax represents the highest bar from right
        int rightMax = Integer.MIN_VALUE;

        // use two pointers to scan the entire array until they meet with each other
        // Key points: any bars in the middle of leftMax bar and rightMax bar will not influence
        // how much water can current position trap
        for (int left = 0, right = height.length - 1; left <= right;) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            //how much can current position trap depends on the shorter bar
            if (leftMax < rightMax) {
                //DO NOT FORGET to subtract bar height of current position
                result += leftMax - height[left];
                left++;
            } else {
                //find difference between tallest wall to the right
                //and current height [lower level land] and add to result if
                //there is capacity to hold water e.g. index 9 and 10
                // height 1 and 2 on the right adds 1 [2-1]
                //to the result
                result += rightMax - height[right];
                right--;   
            }
        }
        return result;
    }
}
// @lc code=end



