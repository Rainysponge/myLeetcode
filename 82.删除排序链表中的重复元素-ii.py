#
# @lc app=leetcode.cn id=82 lang=python3
#
# [82] 删除排序链表中的重复元素 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head or not head.next: return head
        dummy = ListNode(-1)
        dummy.next = head
        
        temp = dummy
 
        while temp.next.next != None:
            if temp.next.val == temp.next.next.val:
                temp1 = temp.next.next
                while temp1.next != None and temp1.next.val == temp.next.val:
                    temp1 = temp1.next
                temp.next =temp1.next
                if temp.next == None: break
            else: temp = temp.next
        return dummy.next

        
# @lc code=end

