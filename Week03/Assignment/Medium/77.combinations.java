/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        int index = 1;
        helper(n, k, index, curr, result);
        return result;
    }
    public void helper(int n, int k, int index, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            helper(n, k , i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

