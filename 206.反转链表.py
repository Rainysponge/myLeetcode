#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # # 利用栈实现

        # stack = []
        # if not head:
        #     return None
        # tmp = head
        # while tmp:
        #     stack.append(tmp)
        #     tmp = tmp.next
        # res = ListNode(0)
        # res.next = None
        # tmp = res
        # while stack:
        #     tNode = stack.pop()
        #     tNode.next = None
        #     tmp.next = tNode
        #     tmp = tmp.next
        # tmp.next = None
        # return res.next


        # 递归
        if not head or not head.next:
            return head
        

        newListNode = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return newListNode





# @lc code=end

