/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) {
                return curr;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;

            if (slow == fast) {
                ListNode restart = head;
                while (restart != slow) {
                    slow = slow.next;
                    restart = restart.next;    
                }
                return slow;
            }
        }
        return null;
    }
}
// @lc code=end

