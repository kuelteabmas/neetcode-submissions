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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode nxt = temp;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                nxt.next = list1;
                list1 = list1.next;
            } else {
                nxt.next = list2;
                list2 = list2.next;
            }
            nxt = nxt.next;
        }

        if (list1 == null) {
            nxt.next = list2;
        } else { // list2 == null
            nxt.next = list1;
        }
        return temp.next; 
    }
}