#
# @lc app=leetcode.cn id=109 lang=python3
#
# [109] 有序链表转换二叉搜索树
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return None
        
        mid = self.findMiddlePointer(head)
        root = TreeNode(mid.val)
        if mid == head:
            return root
        
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(mid.next)
        return root

        # return root
        

    def findMiddlePointer(self, head):
        pre = None
        fast = head
        slow = head
        while fast and fast.next:
            pre = slow
            fast = fast.next.next
            slow = slow.next
        if pre:
            pre.next = None

        return slow

# @lc code=end

