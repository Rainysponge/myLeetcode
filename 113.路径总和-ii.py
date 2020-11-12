#
# @lc app=leetcode.cn id=113 lang=python3
#
# [113] 路径总和 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        self.dfs(root, sum, res, [])
        return res

    def dfs(self, root, sum, res, List):
        if not root:
            return
        if not root.left and not root.right:
            if sum == root.val:
                res.append(List + [root.val])
        self.dfs(root.left, sum-root.val, res, List + [root.val])
        self.dfs(root.right, sum-root.val, res, List + [root.val])

# # @lc code=end

