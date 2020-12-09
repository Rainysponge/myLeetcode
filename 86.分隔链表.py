#
# @lc app=leetcode.cn id=86 lang=python3
#
# [86] 分隔链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        small = ListNode(0)
        # 用两个新指针，分别记录比x值小的和比x值大的
        large = ListNode(0)
        small_root, large_root = small, large
        while head:
            if head.val < x:
                small.next = head
                small = small.next
            else:
                large.next = head
                large = large.next
            temp = head.next
            head.next = None
            head = temp
        small.next  = large_root.next
        return small_root.next
# @lc code=end

