#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # #这个想法很有意思
        # h = ListNode(0)
        # h.next = head
        # left,right = h,h

        # for _ in range(n+1):
        #     left = left.next

        # while left != None:
        #     left = left.next
        #     right = right.next

        # right.next = right.next.next
        # return h.next

        # 0310
        beforeHead = ListNode(0)
        beforeHead.next = head
        fast, slow = beforeHead, beforeHead

        for _ in range(n+1):
            fast = fast.next
        while fast:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return beforeHead.next




# @lc code=end

