/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] ob : obstacles) {
            set.add(ob[0] + "," + ob[1]);
        }

        //follow the order with north->east->south->west
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int dir = 0;
        int x = 0;
        int y = 0;
        int result = 0;

        for (int com : commands) {
            if (com == -1) {
                dir = (dir + 1) % 4;
            }else if (com == -2) {
                dir = (dir + 3) % 4;
            } else {
                while (com > 0) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    String next = newX + "," + newY;
                    
                    if (set.contains(next)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                    com--;
                }
            }
            result = Math.max(result, x * x + y * y);
        }

        return result;
    }
}
// @lc code=end

