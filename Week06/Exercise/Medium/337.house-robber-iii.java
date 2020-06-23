/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    public int[] helper(TreeNode root) {
        if (root == null) {
            int[] temp = {0, 0};
            return temp;
        }
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        //Choose the current node
        result[0] = left[1] + right[1] + root.val;
        //Do not choose the current node
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }

}
// @lc code=end

