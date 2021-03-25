#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] 排序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # 这居然是归并
        
        if head is None or head.next is None:
            return head
        mid = self.get_mid(head)
        l = head
        r = mid.next
        mid.next = None
        return self.merge(self.sortList(l), self.sortList(r))

    def merge(self, p, q):
            tmp = ListNode(0)
            h = tmp
            while p and q:
                if p.val < q.val:
                    h.next = p
                    p = p.next
                else:
                    h.next = q
                    q = q.next
                h = h.next
            if p:
                h.next = p
            if q:
                h.next = q
            return tmp.next

    def get_mid(self, node):
        if node is None:
            return node
        fast = slow = node
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
# ————————————————
# 版权声明：本文为CSDN博主「神不烦」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
# 原文链接：https://blog.csdn.net/qq_34364995/article/details/80994110
        
        





        
# @lc code=end

