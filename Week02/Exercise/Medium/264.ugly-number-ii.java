/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);

        for (int i = 1; i < n; i++) {
            long number = heap.poll();

            while (!heap.isEmpty() && heap.peek() == number) {
                number = heap.poll();
            }
            heap.add(number * 2);
            heap.add(number * 3);
            heap.add(number * 5);
        }
        return heap.poll().intValue();
    }
}
// @lc code=end

