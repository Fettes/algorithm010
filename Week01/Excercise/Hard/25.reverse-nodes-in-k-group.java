/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
         if (k == 1) {
             return head;
         }

         ListNode curr = head;
         ListNode countNode = head;
         ListNode reverseList = null;
         ListNode tail = null;
         ListNode result = new ListNode(-1);
         int count = 1;

         while (countNode != null && countNode.next != null) {
            countNode = countNode.next;
            count++;

            if (count == k) {
                // Save the tail
                tail = countNode.next;
                // Cut the tail
                countNode.next = null;
                // Reverse the K-Group
                reverseList = reverse(curr);
                // Reset all the counting variables
                curr = tail;
                countNode = tail;
                count = 1;
            }
            // When it haven't reach the end
            if (reverseList != null) {
                // Link the reverse List
                result = LinkNode(result, reverseList);
                // Reset
                reverseList = null;
            }
         }
         //Nodes remaining linking
         result = LinkNode(result, tail);
         return result.next;
    }

    private ListNode LinkNode(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;

        /*
        Future Improvement:
        Every time we traverse the result list. How about saving the tail node of the result list?
        */
        while (l1.next != null) {
            l1 = l1.next;
        }
        l1.next = l2;
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
// @lc code=end

