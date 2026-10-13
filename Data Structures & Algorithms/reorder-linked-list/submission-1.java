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
        
        // 1. reverse linkedlist
        // 2. merged list and revlist until curr node of merging operation is dupe then stop merging
        // 3. return mergList

        // 1. reverse linkedlist
        ListNode prev = null; 
        ListNode revList = head;
        ListNode mergedList = head;


        int count = 0;

        while (revList != null) {
            ListNode temp = revList.next;
            prev = revList;
            revList = temp;
            count++;
        }

        // 2. merged list and revlist until curr node of merging operation is dupe then stop merging
        // ListNode mergedList = head;
        ListNode curr = mergedList;


        // when to stop merge?
        // 2 -> 4 -> 6 -> 8 | head
        // 8 -> 6 -> 4 -> 2 | revList
        // __________
        // 2 -> 8 -> 4 -> 6 

        //  
        while (count > 0) {
            curr.next = mergedList;
            mergedList = revList;
            revList = mergedList.next;
            mergedList.next = revList.next;

            count--;
            curr = curr.next;
        }
    }
}
