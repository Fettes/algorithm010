/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (k == 0 || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);
                return count2 - count1;
            }
        });

        for (int key : map.keySet()) {
            heap.add(key);
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;   
    }
}
// @lc code=end

