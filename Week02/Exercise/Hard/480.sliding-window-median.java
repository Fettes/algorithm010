import java.util.Collection;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int right = nums.length - k + 1;
        double[] result = new double[right];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            addNumber(nums[i]);
            if (minHeap.size() + maxHeap.size() == k) {
                result[index++] = getMedian();
                remove(nums[i - k + 1]); 
            }
        }
        return result;
    }

    public void addNumber(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + (double)maxHeap.peek()) * 0.5;
        } else {
            return (double)minHeap.peek();
        }
    }

    public boolean remove(int x) {
        return minHeap.remove(x) || maxHeap.remove(x);
    }
}
// @lc code=end

