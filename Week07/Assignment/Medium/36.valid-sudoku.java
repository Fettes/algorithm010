/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] column = new HashMap[9];
        Map<Integer, Integer>[] box = new HashMap[9];
        
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            column[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    int number = (int) num;
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    //put the cell value into hashmap
                    row[i].put(number, row[i].getOrDefault(number, 0) + 1);
                    column[j].put(number, column[j].getOrDefault(number, 0) + 1);
                    box[boxIndex].put(number, box[boxIndex].getOrDefault(number, 0) + 1);

                    if (row[i].get(number) > 1 || column[j].get(number) > 1 || box[boxIndex].get(number) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
// @lc code=end

