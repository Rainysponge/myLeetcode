package LC;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc783 {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    int pre;

    public int minDiffInBST(TreeNode root) {
        // 最小值一定出现在相邻的两个节点！
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;

    }
    public int minDiffInBST1(TreeNode root) {
        // 最小值一定出现在相邻的两个节点！
        // 使用堆栈的方式实现中序遍历
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()){
            while(root != null){
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (prev != null) {
                assert root != null;
                ans = Math.min(ans, Math.abs(prev.val - root.val));

            }
            prev = root;
            root = root.right;


        }

        return ans;


    }

    public void dfs(TreeNode root){
        // 中序遍历
        if(root==null) return;
        dfs(root.left);
        System.out.println(root.val);
        if (pre != -1) {

            this.ans = Math.min(this.ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);


    }
}

