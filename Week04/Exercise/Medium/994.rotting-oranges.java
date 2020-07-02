/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        int level = 0;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty() && freshOrange > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int[] dir : directions) {
                    int newRow = point[0] + dir[0];
                    int newCol = point[1] + dir[1];

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow, newCol});
                    freshOrange--;
                }
            }
            level++;
        }
        return freshOrange == 0 ? level : -1;
    }
}
// @lc code=end

