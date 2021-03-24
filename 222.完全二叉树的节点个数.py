#
# @lc app=leetcode.cn id=222 lang=python3
#
# [222] 完全二叉树的节点个数
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        # 基于这两个性质，我们可以这样思考。如果右子树
        # 的高度等于整棵二叉树的高度-1的话，那么左子
        # 树一定是一棵满二叉树，这个时候我们就很容易的
        # 计算出总结点数nodes=2**(h)-1 + 1 +右子树节
        # 点数（这里的+1表示root节点）。如果右子树的高
        # 度不等于整棵二叉树的高度-1的话，那么左子树不
        # 一定是一棵满二叉树，但是有一点可以确定，右子
        # 树一定是一棵满二叉树，这个时候我们就很容易的
        # 计算出总结点数nodes=2**(h-1)-1 + 1 +左子树
        # 节点数（这里的+1表示root节点）。根据这个思路
        # 我们只要不断循环下去直到root==None结束。



        # if not root:
        #     return 0
        # if root.left and root.right:
        #     return self.countNodes(root.left) + self.countNodes(root.right) + 1
        # if root.left:
        #     return self.countNodes(root.left) + 1
        # if root.right:
        #     return self.countNodes(root.right) + 1
        # return 1
        def height(t):
            h = -1
            while t:
                h += 1
                t = t.left
            return h
        
        h = height(root)

        nodes = 0
        while root:
            if height(root.right) == h - 1: 
                nodes += 2**h
                root = root.right
            else:
                nodes += 2**(h - 1)
                root = root.left

            h -= 1

        return nodes







# @lc code=end

