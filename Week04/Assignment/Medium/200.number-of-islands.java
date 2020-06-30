/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int count = 0;
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{1, 0});
        directions.add(new int[]{0, 1});
        directions.add(new int[]{-1, 0});
        directions.add(new int[]{0, -1});

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int row = point[0];
                        int col = point[1];

                        for (int[] dir : directions) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == '0') {
                                continue;
                            }
                            queue.add(new int[]{newRow, newCol});
                            grid[newRow][newCol] = '0';
                        }
                    }
                }
            }
        }
        return count;

    }
}
// @lc code=end

