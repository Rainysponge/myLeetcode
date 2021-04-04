/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // int Max = 0;
    public int maxDepth(TreeNode root) {
        int res = 0;  // 表示当前深度
        if (root == null){
            return 0;
        }
        res++;
        if(root.left!=null){
            res = Math.max(res, 1 + maxDepth(root.left));
            // return 1;
        }
        if(root.right!=null){
            res = Math.max(res, 1 + maxDepth(root.right));
            // return 1;
        }
        return res;
    }
}
// @lc code=end

