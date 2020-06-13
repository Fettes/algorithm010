import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    PriorityQueue<Integer> heap;
    int index;
    public KthLargest(int k, int[] nums) {
        this.index = k;
        //Maintain a min Heap with capacity k, the top element would be the kth largest
        heap = new PriorityQueue<>(k);

        for (int number : nums) {
            heap.add(number);
            if (heap.size() > index) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() == index + 1) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

