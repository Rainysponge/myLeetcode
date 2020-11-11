#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        # root = TreeNode(preorder[0])        
        # left_inorder = inorder[: inorder.index(root.val)]
        # right_inorder = inorder[inorder.index(root.val) + 1 :]
         
        # l_left = len(left_inorder)
        # left_preorder = preorder[1:l_left + 1]
        # right_preorder = preorder[l_left + 1 :]
        
        # root.left = self.buildTree(left_preorder, left_inorder)
        # root.right = self.buildTree(right_preorder, right_inorder)
        
        # return root

        root = TreeNode(preorder[0])
        left_inorder = inorder[:inorder.index(root.val)]
        right_inorder = inorder[inorder.index(root.val)+1:]

        left_len = len(left_inorder)
        left_preorder = preorder[1:left_len+1]
        right_preorder = preorder[left_len+1:]

        root.left = self.buildTree(left_preorder, left_inorder)
        root.right = self.buildTree(right_preorder, right_inorder)

        return root
 


# @lc code=end

