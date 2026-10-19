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
        // 1. find midpoint with floyd's algo 2 pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse list's 2nd half
        ListNode second = slow.next;
        
        slow.next = null; // other delimiter fofr diving the list into 2 halves
        ListNode prev = null;

        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // 3. merge the 2 lists
        ListNode first = head;
        // currently, prev is the head of the reversed 2nd half
        // and second is null
        second = prev; // this sets second to be head of reverse 2nd half

        while (second != null) { // since second hlaf will never be larger than first half, second != null is our condition
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // update nodes by inserting second node between first node and first's next node (first.next) which is temp1
            first.next = second;
            second.next = temp1; 

            // shift our pointers
            first = temp1;
            second = temp2;
        }


    }
}
