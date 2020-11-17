#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return []
        self.inorderfunc(res,root)
        return res
    def inorderfunc(self, res, root):
        if root == None:
            return 
        self.inorderfunc(res, root.left)
        res.append(root.val)
        self.inorderfunc(res, root.right)
        
# @lc code=end

