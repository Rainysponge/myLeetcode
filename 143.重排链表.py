#
# @lc app=leetcode.cn id=143 lang=python3
#
# [143] 重排链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return

        pre = head
        lat = head.next
        while lat != None and lat.next != None:
            pre = pre.next
            lat = lat.next.next

        p = pre.next
        pre.next = None
        # reverse
        
        cur = None        
        while p != None:
            q = p.next
            p.next = cur
            cur = p 
            p = q
               
        pre = head
        while pre != None and cur != None:
            tmp = cur.next  
            cur.next = pre.next
            pre.next = cur
            pre = pre.next.next
            cur = tmp







# @lc code=end

