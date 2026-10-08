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

        HashMap<Integer, ListNode> map = new HashMap<>();

        int i = 0;
        ListNode curr = head;

        while (curr != null) {
            if (map.containsValue(curr)) {
                return true;
            }
            map.put(i, curr);
            i++;
            curr = curr.next;
        }

        return false;
    }
}
