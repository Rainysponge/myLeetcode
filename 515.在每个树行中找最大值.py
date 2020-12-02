#
# @lc app=leetcode.cn id=515 lang=python3
#
# [515] 在每个树行中找最大值
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # bfs
        if not root:
            return []
        queue = [root]
        tmp = []
        row = []
        res = []
        while queue:
            t = queue.pop(0)
            row.append(t.val)
            if t.left:
                tmp.append(t.left)
            if t.right:
                tmp.append(t.right)
            if not queue:
                res.append(max(row))
                queue = tmp
                tmp = []
                row = []
        return res

# @lc code=end

