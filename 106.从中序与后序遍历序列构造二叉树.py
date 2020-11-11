#
# @lc app=leetcode.cn id=106 lang=python3
#
# [106] 从中序与后序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder:
            return None
        root = TreeNode(postorder[-1])
        left_inorder = inorder[:inorder.index(root.val)]
        right_inorder = inorder[inorder.index(root.val)+1:]

        right_len = len(right_inorder)
        right_postorder = postorder[-right_len-1:-1]
        left_postorder = postorder[0:-right_len-1]

        root.right = self.buildTree(right_inorder,right_postorder)
        root.left = self.buildTree(left_inorder, left_postorder)

        return root



# @lc code=end

