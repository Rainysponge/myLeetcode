package LC;
import dataStructure.TreeNode;


//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//        https://leetcode-cn.com/problems/validate-binary-search-tree/
//        假设一个二叉搜索树具有如下特征：
//
//        节点的左子树只包含小于当前节点的数。
//        节点的右子树只包含大于当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。


//import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc98 {
    public boolean isValidBST(TreeNode root) {
//        return true;
        //中序遍历
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val < inorder){
                return false;
            }
            inorder = root.val;
//            if(root.right != null){
//                root.right
//            }
            root = root.right;

        }
        return true;

    }

//    public boolean isValidBST(TreeNode root, long low, long  high){
////        Integer.MAX_VALUE
////        boolean flag = false;
//        if(root == null){
//            return true;
//        }
//        if(root.val <= low || root.val >= high){
//            return false;
//        }else{
//            return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
//        }
//
//
//
//    }
}
