/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }
        int index = 0;
        helper(index, nums, curr, result);
        return result;
    }
    public void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(i + 1, nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

