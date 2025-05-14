# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        node = ListNode()
        current = node
        carry = 0

        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            s = val1 + val2 + carry
            carry = s // 10
            current.next = ListNode(s % 10)
            current = current.next

            if l1:
                l1 = l1.next

            if l2:
                l2 = l2.next

        return node.next
    
print(Solution().addTwoNumbers([2, 4, 3], [5, 6, 4]))
print(Solution().addTwoNumbers([9, 9, 9, 9, 9, 9, 9], [9, 9, 9, 9]))
print(Solution().addTwoNumbers([0], [0]))