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
    public ListNode reverseList(ListNode head) {
        // null <- 1 -> 2 -> 3 -> null
        // prev   curr
        //        prev  curr
        //              prev  curr
        //                  prev    curr

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; // move to next curr ListNode during iteration
            prev = curr; // shift our prev pointer to curr pointer
            curr = temp; // shift our curr pointer to next node --> curr.next
        }

        return prev;
    }
}
