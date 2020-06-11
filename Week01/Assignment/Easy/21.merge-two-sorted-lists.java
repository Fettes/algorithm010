/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode count = new ListNode(-1);
        ListNode dummy = count;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                count.next = l1;
                l1 = l1.next;
            } else {
                count.next = l2;
                l2 = l2.next;
            }
            count = count.next;
        }

        if (l1 == null) {
            count.next = l2;
        } else if (l2 == null) {
            count.next = l1;
        }

        return dummy.next;
    }
}
// @lc code=end

