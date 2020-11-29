#
# @lc app=leetcode.cn id=606 lang=python3
#
# [606] 根据二叉树创建字符串
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def tree2str(self, t: TreeNode) -> str:
        if not t :
            return ''
        res = str(t.val)
        if not t.left and not t.right:
            return res
        if t.left:
            res += '(' + self.tree2str(t.left) + ')'
        else:
            res += '()'
        if t.right:
            res += '('+ self.tree2str(t.right) +')'
        return res

# @lc code=end

