#
# @lc app=leetcode.cn id=103 lang=python3
#
# [103] 二叉树的锯齿形层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        queue = [root]
        res = []
        flag = True
        if not root :
            return []
        while queue:
            tmplist = []
            tmplen = len(queue)
            for i in range(tmplen):
                tmp = queue.pop(0)
                tmplist.append(tmp.val)
                if tmp.left:
                    queue.append(tmp.left)
                if tmp.right:
                    queue.append(tmp.right)
            if flag:
                res.append(tmplist)
                flag = False
            else:
                flag = True
                # tmplist = tmplist[::-1]
                res.append(tmplist[::-1])
        return res
# @lc code=end

