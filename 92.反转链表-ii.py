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

        if not head and not head.next:
            return head

        headNode = ListNode(0)
        headNode.next = head


        pre = headNode
        alt = pre.next

        while m > 1:
            pre = pre.next
            alt = alt.next
            n -= 1
            m -= 1
        m_alt, m_pre = alt, pre
        while n:
            n -= 1
            tmp = alt.next
            alt.next = pre
            pre = alt
            alt = tmp

        m_pre.next = pre
        m_alt.next = alt
        return headNode.next





# @lc code=end

