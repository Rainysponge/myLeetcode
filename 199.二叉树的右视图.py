#
# @lc app=leetcode.cn id=199 lang=python3
#
# [199] 二叉树的右视图
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # BFS
        queue = []
        if not root:
            return []
        queue.append(root)
        nowRoot = []
        List = []
        res = []
        count = 0
        while queue:
            tmp = queue.pop(0)
            nowRoot.append(tmp)
            if tmp.left:
                List.append(tmp.left)
            if tmp.right:
                List.append(tmp.right)
            if not queue:
                res.append(nowRoot[-1].val)
                nowRoot = []
                queue = List
                List = []
                count += 1
            # if count == 2:
            #     return (res,queue[1].val)
        return res
# @lc code=end

