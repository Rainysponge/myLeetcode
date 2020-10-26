#
# @lc app=leetcode.cn id=83 lang=python3
#
# [83] 删除排序链表中的重复元素
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        a = head
        if head == None:
            return head
        while a.next != None:
            if a.val != a.next.val:
                a = a.next
                continue
            else:
                a.next = a.next.next
        return head
# @lc code=end

