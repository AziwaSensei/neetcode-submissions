# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # prev,curr,next
        prev,curr = None, head
        result = prev

        while head is not None:
            curr = head.next
            head.next = prev
            prev = head
            head = curr
        
        print(prev)
        return prev
