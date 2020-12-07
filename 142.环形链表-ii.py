#
# @lc app=leetcode.cn id=142 lang=python3
#
# [142] 环形链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        # 如果链表有环，则让快指针回到链表的头重新出发，
        # 当快慢指针相遇的那个节点即是链表环的起点。
        if not head or not head.next:
            return None
        fast, slow = head, head
        while fast:
            fast = fast.next
            slow = slow.next
            if fast:
                fast = fast.next
            if slow == fast:
                break
        if slow != fast:
            return None
        
        fast = head
        
        while slow:
            if slow == fast: #此点即是环起点
                return slow
            slow = slow.next
            fast = fast.next
 
            
        
        
# @lc code=end

