#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:

        # if not root:
        #     return []
        # res = []
        # res += self.postorderTraversal(root.left)
        # res += self.postorderTraversal(root.right)
        # res.append(root.val)
        # return res


        if not root:
            return []
        
        tmp = [root]
        res = []
        while tmp:
            tmp_root = tmp.pop()
            res.append(tmp_root.val)
            
            if tmp_root.left:
                tmp.append(tmp_root.left)
            if tmp_root.right:
                tmp.append(tmp_root.right)
        return res[::-1]








# @lc code=end

