import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> setJ = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            setJ.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (setJ.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

