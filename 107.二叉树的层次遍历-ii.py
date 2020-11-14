#
# @lc app=leetcode.cn id=107 lang=python3
#
# [107] 二叉树的层次遍历 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        queue = [root]
        res = []
        flag = True
        if not root :
            return []
        while queue:
            tmplist = []
            tmplen = len(queue)
            for i in range(tmplen):
                tmp = queue.pop(0)
                tmplist.append(tmp.val)
                if tmp.left:
                    queue.append(tmp.left)
                if tmp.right:
                    queue.append(tmp.right)
            if flag:
                res.append(tmplist)
                flag = False
            else:
                tmplist = tmplist[::-1]
                res.append(tmplist[::-1])
                flag = True
            
        return res[::-1]
# @lc code=end

