/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent;
        private int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }   
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
          }
      
          int m = grid.length;
          int n = grid[0].length;
          UnionFind uf = new UnionFind(grid);

          for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  if (grid[i][j] == '1') {
                      grid[i][j] = '0';

                      if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                      }
                      if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + (j - 1));
                      }
                      if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                      }
                      if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + (j + 1));
                      }

                  }
              }
          }
          return uf.getCount();
    }
}
// @lc code=end

