#
# @lc app=leetcode.cn id=114 lang=python3
#
# [114] 二叉树展开为链表
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        while root:
            if root.left:
                pre_node = root.left
                # 同样先找到左子树的最右节点
                while pre_node.right:
                    pre_node = pre_node.right
                # 最右节点指向根节点的右子树
                pre_node.right = root.right
                # 根的右子树指向根的左子树，同时置空左子树
                root.right = root.left
                root.left = None
            root = root.right

        
# @lc code=end

