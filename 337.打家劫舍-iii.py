#
# @lc app=leetcode.cn id=337 lang=python3
#
# [337] 打家劫舍 III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        # 用到了一个有两个元素的列表，分别保
        # 存了之前层的，不取节点和取节点的情
        # 况。然后遍历左右子树，求出当前节点
        # 取和不取能得到的值，再返回给上一层。
        def dfs(root):
            if not root:
                return [0, 0]
            robleft = dfs(root.left)
            robright = dfs(root.right)
            # 不取该节点
            noroot = robleft[1] + robright[1]
            # 该节点de最大值
            rootcurr = max(root.val+robleft[0]+robright[0], noroot)
            return [noroot, rootcurr]
        return dfs(root)[1]


        
# @lc code=end

