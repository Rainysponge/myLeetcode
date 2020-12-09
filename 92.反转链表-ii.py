#
# @lc app=leetcode.cn id=92 lang=python3
#
# [92] 反转链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if head ==None:
            return 
        if m ==n:
            return head        
        stack = []
        first = ListNode(0)
        while head:
            stack.append(head.val)
            head = head.next
        stack[m-1:n] = reversed(stack[m-1:n])
        res = first
        while stack:
            first.next = ListNode(stack.pop(0))
            first = first.next
        return res.next

# @lc code=end

