/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
    public List<Integer> preorder(Node root) {
        Stack<Node> nodes = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node curr = nodes.pop();
            result.add(curr.val);

            int size = curr.children.size();
            if (size != 0) {
                for (int i = size - 1; i >= 0; i--) {
                    nodes.add(curr.children.get(i));
                }
            }
        }
        return result;
    }
}
// @lc code=end

