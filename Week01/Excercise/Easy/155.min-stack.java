import java.util.Deque;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    Deque<Integer> element;
    Deque<Integer> minElement;
    /** initialize your data structure here. */
    public MinStack() {
        element = new LinkedList<>();
        minElement = new LinkedList<>();
    }
    
    public void push(int x) {
        int currMin;
        if (minElement.size() == 0) {
            currMin = Integer.MAX_VALUE;
        } else {
            currMin = minElement.peekLast();
        }
        element.addLast(x);
        if (x < currMin) {
            minElement.addLast(x);
        } else {
            minElement.addLast(currMin);
        }
    }
    
    public void pop() {
        element.removeLast();
        minElement.removeLast();
    }
    
    public int top() {
        return element.peekLast();
    }
    
    public int getMin() {
        return minElement.peekLast();
    }
}
/*
I found Stack is more efficienet than Deque.
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

