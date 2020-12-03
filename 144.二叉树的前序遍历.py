#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:    
        # 递归
        # if not root :
        #     return []
        # res = []
        # def preorder(root):
        #     if not root:
        #         return 
        #     res.append(root.val)
        #     preorder(root.left)
        #     preorder(root.right)
        # preorder(root)
        # return res


        # 迭代
        result = []
        stack = []
        while stack or root:
            while root:
                result.append(root.val)
                stack.append(root)
                root = root.left
            root = stack.pop()
            # 用栈方法， 但也没快夺嫂呀
            root = root.right
        return result
        

# @lc code=end

