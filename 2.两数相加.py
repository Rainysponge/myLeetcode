#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        nums1 = 0
        i = 0
        nums2 = 0
        while l1 != None:
            nums1 += l1.val*10**i
            i += 1
            l1 = l1.next
        i = 0
        while l2 != None:
            nums1 += l2.val*10**i
            i += 1
            l2 = l2.next
        
        result = nums1 + nums2
        t = result % 10
        l3 = ListNode(t)
        tail = l3
        result = result // 10
        while result > 0:
            #  result = result // 10
            t = result % 10
            newlistnode = ListNode(t)
            tail.next = newlistnode
            tail = newlistnode
            result = result // 10
        return l3 

# @lc code=end

