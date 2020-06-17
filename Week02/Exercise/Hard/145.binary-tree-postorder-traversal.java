/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();
            result.add(curr.val);

            if (curr.left != null) {
                nodes.add(curr.left);
            }

            if (curr.right != null) {
                nodes.add(curr.right);
            } 
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end

