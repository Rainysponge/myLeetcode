#
# @lc app=leetcode.cn id=129 lang=python3
#
# [129] 求根到叶子节点数字之和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        sumList = []
        self.dfs(sumList, 0, root)
        return sum(sumList)

    def dfs(self, sumList, Sumtmp, root):
        
        Sumtmp = Sumtmp*10 + root.val
        if root.left:
            self.dfs(sumList, Sumtmp, root.left)
        if root.right:
            self.dfs(sumList, Sumtmp, root.right)
        if not root.right and not root.left:
            sumList.append(Sumtmp)
            return


# @lc code=end

