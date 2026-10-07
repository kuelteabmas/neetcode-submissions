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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nxt = curr.next; // 2. temp node - the original next node; now that we have curr.next saved in temp node, it won't be lost
            curr.next = prev;
            prev = curr;
            // curr = curr.next; // 1. not correct since here, we previously set curr.next to prev, we need to initialize a new temp node.
            curr = nxt; // 3. instead of curr = curr.next; which would cause us to lose curr.next
        }
        return prev;
    }
}
