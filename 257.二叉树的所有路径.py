#
# @lc app=leetcode.cn id=257 lang=python3
#
# [257] 二叉树的所有路径
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []

        def dfs(root, path):
            if not root:
                # ans.append(tmp)
                return
            path = path + [str(root.val)]
            if not root.left and not root.right:
                return res.append("->".join(path))
            dfs(root.left, path)
            dfs(root.right, path)
        
        
        
        if not root:
            return res
        dfs(root,[])
        return res
        



    
# @lc code=end

