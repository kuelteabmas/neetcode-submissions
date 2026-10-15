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
        // 1. find middle point -- in order to obtain 2 halves of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse list's 2nd half
        ListNode second = slow.next; // head of 2nd half before being reversed
        
        slow.next = null; // the last node of the 1st half to point to null and not to the head of 2nd half | this also complete's the split of the list in half but pointing the last node to null
        ListNode prev = null;

        while(second != null) {
            ListNode temp = second.next;
            second.next = prev; // update to the next node
            prev = second; // shift prev pointer
            second = temp; // shift second pointer
        }
        // after this reversal, 
        // second will be set to null
        // and prev will the new head of the reversed 2nd half of the list which is also the beginning

        // 3. Merge list's 1st half with 2nd reversed half
        ListNode first = head; // set first to beginning of list
        second = prev; // set second which null after reversal to become head of reversed 2nd half of list
        
        while (second != null) { // since we know that the 2nd half will be the short list between the 2 halves, we will use second as our if condition
            
            // temp nodes to hold the value of the iteration's next first node and next second node before we shift pointers to the next first node and next second node
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // we insert second between first and first.next (which is temp1)

            // first -> second -> first.next (temp1) -> .... -> | loop continues till second is null
            first.next = second; // first -> second  | -> is first.next
            second.next = temp1; // second -> first.next | -> is second.next

            // now, we shift pointers
            first = temp1;
            second = temp2;
        }

    }
}
