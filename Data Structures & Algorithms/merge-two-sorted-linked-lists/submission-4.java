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
        // If memory is not an issue lets create a new list O(n+m)
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        //result = dummy;
        // list 1: [1 4 6 8 9 13 60 69]
        // list 2: [2 3 5 7 10]
        // iterate through list1 and list2
        while(list1 != null && list2 != null) {
            // compare the values of the current nodes
            if (list1.val > list2.val) {
                // we should append the smaller value first always
                result.next = list2;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                // when the values are the same just move the top one
                result.next = list1;
                list1 = list1.next;
            }
            //update the result node
            result = result.next;
        }

        // We reach the end of one list so lets append the other
        if (list1 != null) {
            // list one is empty add list2 to result
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }
        
        return dummy.next;

    }
}