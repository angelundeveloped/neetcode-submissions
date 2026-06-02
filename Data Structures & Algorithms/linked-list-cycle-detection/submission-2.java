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
        //todo: edge cases
        ListNode fast = head;
        ListNode slow = head;

        // Lets traverse this cycle unitl either fast reaches null or finds slow
        while (fast != null && fast.next != null) { // check this logig
            //update the nodes
            slow = slow.next;
            fast = fast.next.next;

            // check if the two nodes are in the same place
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
