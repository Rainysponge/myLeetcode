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
        # nums1 = 0
        # i = 0
        # nums2 = 0
        # while l1 != None:
        #     nums1 += l1.val*10**i
        #     i += 1
        #     l1 = l1.next
        # i = 0
        # while l2 != None:
        #     nums1 += l2.val*10**i
        #     i += 1
        #     l2 = l2.next
        
        # result = nums1 + nums2
        # t = result % 10
        # l3 = ListNode(t)
        # tail = l3
        # result = result // 10
        # while result > 0:
        #     #  result = result // 10
        #     t = result % 10
        #     newlistnode = ListNode(t)
        #     tail.next = newlistnode
        #     tail = newlistnode
        #     result = result // 10
        # return l3 
        if not l1:
            return l2
        if not l2:
            return l1
        flag = 0
        if l1 and l2:
            
            if l1.val+l2.val > 9:
                res = ListNode(l1.val+l2.val-10)
                flag = 1
            else:
                res = ListNode(l1.val+l2.val)
                # flag = False
            l1 = l1.next
            l2 = l2.next
            res.next = None
        tmp = res
        while l1 and l2:
            if l1.val+l2.val + flag > 9:
                t = ListNode(l1.val+l2.val + flag -10)
                flag = 1
            else:
                t = ListNode(l1.val+l2.val+ flag)
                flag = 0
            t.next = None
            tmp.next = t
            tmp = t
            l1 = l1.next
            l2 = l2.next
        if not l1 and not l2:
            if flag > 0:
                t = ListNode(1)
                t.Next = None
                tmp.next = t
            #     return res
            # else:
            return res
        if not l1:
            while l2:
                if l2.val + flag > 9:
                    t = ListNode(l2.val + flag -10)
                    flag = 1
                else:
                    t = ListNode(l2.val+ flag)
                    flag = 0
                t.next = None
                tmp.next = t
                tmp = t
                l2 = l2.next
            
        if not l2:
            while l1:
                if l1.val + flag > 9:
                    t = ListNode(l1.val + flag -10)
                    flag = 1
                else:
                    t = ListNode(l1.val+ flag)
                    flag = 0
                t.next = None
                tmp.next = t
                tmp = t
                l1 = l1.next
        if flag == 1:
            t = ListNode(1)
            t.next = None
            tmp.next = t
        return res
            
# @lc code=end

