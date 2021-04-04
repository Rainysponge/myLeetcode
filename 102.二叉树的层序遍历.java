/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmpList = new ArrayList<>();
//            TreeNode tmp =  queue.poll();
            int turn = queue.size();
            
            for(int i=0;i<turn;i++){
                TreeNode tmpNode = queue.poll();
                assert tmpNode != null;
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
                tmpList.add(tmpNode.val); 
            }
            res.add(tmpList);
            
        }
        return res;







    }
}
// @lc code=end

