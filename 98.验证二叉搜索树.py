#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
    #     if not root:
    #         return True
    #     # 遍历左子树
    #     if self.flag and root.left:
    #         self.isValidBST(root.left)
    #     # 当前节点小于父节点, 不是二叉搜索树
    #     if root.val <= self.last:
    #         self.flag = False
    #     self.last = root.val
    #     # 遍历右子树
    #     if self.flag and root.right:
    #         self.isValidBST(root.right)
    #     return self.flag

    # def __init__(self):
    #     self.flag = True
    #     self.last = -float(inf)
    # 中序遍历
        res = []
        self.search(root, res)
        for i in range(1, len(res)):
            if res[i] <= res[i-1]:
                return False
        return True 



    def search(self,root,res):
        if root:
            self.search(root.left, res)
            res.append(root.val)
            self.search(root.right, res)





# @lc code=end

