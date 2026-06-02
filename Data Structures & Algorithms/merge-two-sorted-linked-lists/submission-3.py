# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # ored we need a comparison in each head
        # new_linked_list
        dummy = ListNode()
        new_linked_list = dummy

        while list1 and list2:
            # check values
            if list1.val < list2.val:
                # 1. Attach the smaller node
                new_linked_list.next = list1
                # 2. Advance the pointer of the list we just took from
                list1 = list1.next
            elif list2.val < list1.val:
                # 1. Attach the smaller node
                new_linked_list.next = list2
                # 2. Advance the pointer of the list we just took from
                list2 = list2.next
            else:
                #default to top
                new_linked_list.next = list1
                list1 = list1.next

            # 3. CRITICAL: Advance the pointer of the new merged list
            # This ensures the next attachment is to the end of the chain
            new_linked_list = new_linked_list.next
            
        # once we run out of values in one list, append the rest
        # This part is correct: you attach the whole remaining sublist
        if list1:
            new_linked_list.next = list1
        elif list2: #list2
            new_linked_list.next = list2
        
        # The dummy's next is the head of the new merged list
        return dummy.next