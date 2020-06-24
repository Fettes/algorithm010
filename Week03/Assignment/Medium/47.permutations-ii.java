/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Sorted needed to remove duplicates
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, curr, result);
        return result;        
    }
    public void helper(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            curr.add(nums[i]);
            helper(nums, visited, curr, result);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    } 
}
// @lc code=end

