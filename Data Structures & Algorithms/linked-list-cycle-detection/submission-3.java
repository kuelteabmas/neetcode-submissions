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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // 2 pointer -> Floyd's Fast and Slow Pointer algo
        // 2 pointers (slow and fast) start at the beginning of linked list and then
        // slow -> 1 node -> next node
        // fast -> 2 nodes -> next next node

        ListNode slow = head;
        ListNode fast = head;

        // during loop, fast.next can't be null and fast whill reach the end of the LinkedList before slow
        while (fast != null & fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;

        }
        return false;
    }
}
