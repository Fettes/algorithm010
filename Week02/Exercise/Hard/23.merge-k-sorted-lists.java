/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        while (!heap.isEmpty()) {
            head.next = heap.poll();
            head = head.next;
            //Move to the next node of current list
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;

    }
}
// @lc code=end

