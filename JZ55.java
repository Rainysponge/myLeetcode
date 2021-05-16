package LC;
import dataStructure.TreeNode;

public class JZ55 {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        //平衡二叉树
        Deep(root);
        return res;
    }

    int Deep(TreeNode root){
        if(root == null) return 0;
        int deepLeft = 0, deepRight = 0;
        // 后序
        deepLeft = Deep(root.left) + 1;
        deepRight = Deep(root.right) + 1;

        if(Math.abs(deepLeft-deepRight)>1){
            res = false;
        }
        return Math.max(deepLeft, deepRight);

    }

}
