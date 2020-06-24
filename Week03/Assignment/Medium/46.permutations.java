/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(nums, curr, result);
        return result;        
    }
    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            helper(nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
// @lc code=end

