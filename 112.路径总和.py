#
# @lc app=leetcode.cn id=112 lang=python3
#
# [112] 路径总和
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        # 102/114  [1,2] 1 
    #     if not root:
    #         return False
    #     List = []
    #     self.dfs(root, 0, List)
    #     if sum in List:
    #         return True
    #     return False


    # def dfs(self, root, Sum, List):
    #     if not root:
    #         List.append(Sum)
    #         return
    #     Sum += root.val
    #     self.dfs(root.left,Sum, List)
    #     self.dfs(root.right, Sum, List)
        if not root:
            return False
        sum -= root.val
        if sum == 0 and not root.left and not root.right:
            return True
        return self.hasPathSum(root.left, sum) or self.hasPathSum(root.right, sum)






# @lc code=end

