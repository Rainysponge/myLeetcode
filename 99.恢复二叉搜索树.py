#
# @lc app=leetcode.cn id=99 lang=python3
#
# [99] 恢复二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
       

    # def inOrder(self, root):
    #     # 中序遍历
    #     if not root: return
    #     self.inOrder(root.left)
    #     if self.pre and self.pre.val > root.val:
    #         if not self.first:
    #             self.first = self.pre
    #             # 第一次出现前面比后面的大时，这此时的pre节点就是一个被替换的数
    #         self.second = root
    #         # 第二次出现时，则此时的root为另一个被替换数
    #     self.pre = root
    #     self.inOrder(root.right)

        self.pre, self.first, self.second = None, None, None
        self.search(root)
        self.first.val, self.second.val = self.second.val, self.first.val
    
    def search(self, root):
        if root:
            self.search(root.left)
            if self.pre and self.pre.val > root.val:
                if not self.first:
                    self.first = self.pre
                self.second = root
            self.pre = root
            self.search(root.right)
        else:
            return
        



# @lc code=end

