#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] 两两交换链表中的节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head 
        # a = ListNede(0)
        # 递归法

        node1, node2 = head, head.next
        tmp = self.swapPairs(node2.next)
        node2.next = node1
        node1.next = tmp
        return node2

        # 非递归

        # dummy = ListNode(0)
        # dummy.next = head
        # pre = dummy
        # while pre.next and pre.next.next:
        #     node1, node2 = pre.next, pre.next.next
        #     pre.next, node1.next = node2, node2.next
        #     node2.next = node1
        #     pre = node1
        # return dummy.next 

        
# @lc code=end

