#
# @lc app=leetcode.cn id=147 lang=python3
#
# [147] 对链表进行插入排序
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        # if not head and not head.next:
        #     return head
        # pre = ListNode(0)
        # pre.next = head
        # while head.next:
        #     if head.val <= head.next.val:
        #         continue
        #     else:
        #         q = pre
        #         tmp = head.next
        #         head.next = head.next.next
        #         while q.next and q.next.val < tmp.val:
        #             q = q.next
        #         tmp.next = q.next
        #         q.next = tmp

        # return pre.next

        if not head or not head.next: return head
        root = TreeNode(0)
        root.next = head
        while head.next:
            if head.val <= head.next.val:
                head = head.next
            else:
                temp = head.next
                q = root
                head.next = head.next.next
                while q.next and q.next.val < temp.val:
                    q = q.next
                temp.next = q.next
                q.next = temp
        return root.next
# ————————————————
# 版权声明：本文为CSDN博主「负雪明烛」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
# 原文链接：https://blog.csdn.net/fuxuemingzhu/article/details/80785630


# @lc code=end

