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
    public void reorderList(ListNode head) {
        // find midpoint
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse list's 2nd half
        ListNode second = slow.next;

        slow.next = null;
        ListNode prev = null;

        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // merge both lists
        ListNode first = head;
        second = prev;

        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // insert second node between first node and first node's next node
            first.next = second;
            second.next = temp1;

            // shift pointers
            first = temp1;
            second = temp2;
        }

    }
}
