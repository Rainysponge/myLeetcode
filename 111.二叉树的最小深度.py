#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        elif root.left is None and root.right is None:
            return 1
        elif root.left is None:
            return 1 + self.minDepth(root.right)
            # 如果没有左子树则遍历右子树，因为此时的root并不是叶节点
            # 需要继续搜索
        elif root.right is None:
            return 1 +self.minDepth(root.left)
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1
            # pass

# @lc code=end

