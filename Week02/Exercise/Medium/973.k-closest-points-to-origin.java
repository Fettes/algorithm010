/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0) {
            return new int[0][0];
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return distance(p1) - distance(p2);
            }
        });

        for(int[] point : points) {
            heap.add(point);
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = heap.poll();
        }
        return result;

    }

    public int distance(int[] point) {
        int temp = point[0] * point[0] + point[1] * point[1];
        return temp;
    }
}
// @lc code=end

