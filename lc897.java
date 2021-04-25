package LC;
import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
// 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个
// 右子节点。
public class lc897 {
    // 遍历时改变指针方向
    TreeNode cur = new TreeNode();
    public TreeNode increasingBST(TreeNode root){
        TreeNode res = new TreeNode(-1);
        cur = res;

        Inorder(root);
        return res.right;




    }

    private void Inorder(TreeNode root){
        if(root==null) return;
        Inorder(root.left);
        //resNode.right = node;
        //        node.left = null;
        //        resNode = node;
        cur.right = root;
        root.left = null;  // 拆除原先和左子树的链接
        cur = root;
        Inorder(root.right);


    }



}
