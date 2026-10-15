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
        // 1. find midpoint - separate the list in 2 halves
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse list's 2nd half
        ListNode prev = null;
        ListNode second = slow.next;  
        slow.next = null;  
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        } 

        // 3. Merge list's 1st half 
        // and list's 2nd reverse half
        second = prev;
        // prev = null;
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // inserting second node in between first node and first.next node
            first.next = second;
            second.next = temp1;

            // shift pointers
            first = temp1;
            second = temp2;
        }

    }
}
