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
        // null -> 1 -> 2 -> 4 -> null  // list1
        // null -> 1 -> 3 -> 5 -> null  // list2
    
        
        ListNode temp = new ListNode(0); // list to be returned as our merged list
        ListNode curr = temp; // curr node pointer throughout loop

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 == null) {
            curr.next = list2;
        } else if (list2 == null) {
            curr.next = list1;
        }
        return temp.next; 
        // temp.next due to merged list not supposed to have the 0 of temp.val. 
        // Therefore, we return 1 -> 1 -> 2 -> 3 -> 4 -> 5 instead of 0 -> 1 -> 1 -> 2 -> 3 -> 4 -> 5 
    }
}