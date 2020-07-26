/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int row = 0;
        putQueen(row, board, result);
        return result;
    }

    public void putQueen(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                curr.add(new String(board[i]));
            }
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (isValidQueen(board, row, i)) {
                board[row][i] = 'Q';
                putQueen(row + 1, board, result);
                board[row][i] = '.';
            }
        }
    }

    public boolean isValidQueen(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
            //left top check
            int lefttop = column - row + i;
            if (lefttop >= 0 && lefttop < board.length && board[i][lefttop] == 'Q') {
                return false;
            }
            //right top check
            int righttop = column + row - i;
            if (righttop >= 0 && righttop < board.length && board[i][righttop] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

