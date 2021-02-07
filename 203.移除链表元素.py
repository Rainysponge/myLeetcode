#
# @lc app=leetcode.cn id=203 lang=python3
#
# [203] 移除链表元素
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        tmp = head
        if not tmp:
            return head
        if head.val != val and head.next == None:
            return head
        if head.val == val and head.next == None:
            return None
        
        while tmp and tmp.val == val:
            head = tmp.next
            tmp = tmp.next
        
        

        while tmp and tmp.next:
            if tmp.next.val == val:
                tmp.next = tmp.next.next
            else:
                tmp = tmp.next
        return head
            
        


# @lc code=end

