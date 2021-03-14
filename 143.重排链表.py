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
        if not head:
            return None
        
        res = ListNode(0)
        res.next = None
        tmp = res
        nodeList = []

        while head:
            nodeList.append(head)
            head = head.next
        

        listLen = len(nodeList)
        left = 1
        right = listLen - 1
        while right <= left:
            nodeList[right], nodeList[left] = nodeList[left], nodeList[right]
            right -= 1
            left += 1
        while nodeList:
            tmp = nodeList.pop(0)
            t = ListNode(0)
            t.next = None
            tmp.next = t
            tmp = tmp.next
        return res.next






# @lc code=end

