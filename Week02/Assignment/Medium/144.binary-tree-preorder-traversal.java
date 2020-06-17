/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();
            result.add(curr.val);

            if (curr.right != null) {
                nodes.add(curr.right);
            }
            if (curr.left != null) {
                nodes.add(curr.left);
            }
        }
        return result;
    }
}
// @lc code=end

