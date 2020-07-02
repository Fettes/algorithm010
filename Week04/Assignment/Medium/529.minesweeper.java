/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        dfsTraverse(board, r, c);
        return board;
    }

    public void dfsTraverse(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E') {
            return;
        }
        //check if there are any mine around curr point (put the number of mines first)
        int count = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || board[newRow][newCol] != 'M') {
                continue;
            }
            count++;
        }

        //if there are mines, dfs should stop
        if (count > 0) {
            board[row][col] = (char) ('0' + count);
            return;
        }

        //if there is no mine around
        board[row][col] = 'B';
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || board[newRow][newCol] != 'E') {
                continue;
            }
            dfsTraverse(board, newRow, newCol);
        }

    }

}
// @lc code=end

