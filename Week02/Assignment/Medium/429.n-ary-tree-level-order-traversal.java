/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int levelSize = nodes.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node curr = nodes.poll();
                currList.add(curr.val);

                int childSize = curr.children.size();
                if (childSize != 0) {
                    for (int j = 0; j < childSize; j++) {
                        nodes.add(curr.children.get(j));
                    }
                }
            }
            result.add(new ArrayList<>(currList));
        }
        return result;
    }
}
// @lc code=end

