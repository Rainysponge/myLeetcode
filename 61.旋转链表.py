#
# @lc app=leetcode.cn id=61 lang=python3
#
# [61] 旋转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        if k == 0:
            return head
        res = ListNode(0)
        res.next = None
        tmp = res

        nodeList = []
        while head:
            nodeList.append(head)
            head = head.next

        listLen = len(nodeList)
        k = k % listLen
        nodeList = nodeList[listLen-k:] + nodeList[:listLen-k]
        while nodeList:
            tmp.next = nodeList.pop(0)
            tmp = tmp.next
            tmp.next = None

        return res.next







# @lc code=end

