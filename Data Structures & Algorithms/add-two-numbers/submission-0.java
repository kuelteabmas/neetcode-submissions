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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // the plan here is to traverse each list.
        // during traversal, add each nodes value to a string,
        // next, reverse the resulted string 
        // finally, convert string to int

        int int1 = traverseListToString(l1);
        int int2 = traverseListToString(l2);
        int sum = int1 + int2;

        // convert number to linked list by traversing it again
        return intToList(sum);
    }

    private int traverseListToString(ListNode head) {
        String str = "";
        ListNode curr = head;
        while (curr != null) {
            str = str.concat(String.valueOf(curr.val));
            curr = curr.next;
        }

        // before parsing to int, reverse str first
        int num = Integer.parseInt(reverseStrWithSB(str));

        return num;
    }

    private ListNode intToList(int num) {
        String numStr = Integer.toString(num);
        String revNumStr = reverseStrWithSB(numStr);

        int i = 0;

        ListNode node = new ListNode(0);
        ListNode curr = node;
        while (i < revNumStr.length()) {
            char c = revNumStr.charAt(i);
            int digit = Character.getNumericValue(c);

            curr.val = digit; // set value for node i

            // this will prevent the last temp node [ListNode temp = new ListNode(0);] of the last iteration to be attached to our final result.
            if (i != revNumStr.length() - 1) {
                ListNode temp = new ListNode(0); // create temp node to point curr node to
                curr.next = temp; // set pointer to next node i+1, next charAt(i) of str
                curr = curr.next; // shift curr pointer to next node
            }
            i++;
        }
        return node;
    }

    private String reverseStrWithSB(String str) {
        StringBuilder sb = new StringBuilder();
        sb = sb.append(str);
        sb = sb.reverse();
        return sb.toString();
    }
}
