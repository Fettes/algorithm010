/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length == 0 || board == null) {
            return;
        }
        
        boolean result = helper(board);
    }

    public boolean helper(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (helper(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] != '.' && board[i][column] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            char temp = board[(row / 3) * 3 + i / 3][(column / 3) * 3 + i % 3];
            if (temp != '.' && temp == c) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

