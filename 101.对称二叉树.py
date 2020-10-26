#
# @lc app=leetcode.cn id=101 lang=python3
#
# [101] 对称二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        else:
            return self.isSym(root.left, root.right)
        
    def isSym(self, p, q):
        if p == None and q == None:
            return True
        elif p == None or q == None:
            return False
        elif p.val == q.val:
            return self.isSym(p.left, q.right) and self.isSym(p.right, q.left)
        else:
            return False

        

# @lc code=end

