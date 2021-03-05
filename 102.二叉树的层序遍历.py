#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        queque = [root]
        res = []
        if not root:
            return []
        while queque:
            tmpList = []
            queLen = len(queque)
            for i in range(queLen):
                tmp = queque.pop(0)
                tmpList.append(tmp.val)
                if tmp.left:
                    queque.append(tmp.left)
                if tmp.right:
                    queque.append(tmp.right)
            res.append(tmpList)
        return res





        
        
        
        
        
        
        # queue = [root]
        # res = []
        # if not root :
        #     return []
        # while queue:
        #     tmplist = []
        #     tmplen = len(queue)
        #     for i in range(tmplen):
        #         tmp = queue.pop(0)
        #         tmplist.append(tmp.val)
        #         if tmp.left:
        #             queue.append(tmp.left)
        #         if tmp.right:
        #             queue.append(tmp.right)
        #     res.append(tmplist)
        # return res
        
# @lc code=end

