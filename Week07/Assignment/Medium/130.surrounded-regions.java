/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    class UnionFind {
        private int[] parent;

        public UnionFind(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            parent = new int[m * n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        parent[i * n + j] = i * n + j;
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
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        UnionFind uf = new UnionFind(board);
        int m = board.length;
        int n = board[0].length;
        int dummyParent = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    //check whether it is at border
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(dummyParent, i * n + j);
                        continue;
                    }

                    for (int[] dir : directions) {
                        int newX = i + dir[0];
                        int newY = j + dir[1];

                        if (newX >= 0 && newY >= 0 && newX < m && newY < n && board[newX][newY] == 'O') {
                            uf.union(i * n + j, newX * n + newY);
                        }
                    }
                }
            }
        }

        //final step, fill in the X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && uf.find(i * n + j) != uf.find(dummyParent)) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}
// @lc code=end

