package LC;
import dataStructure.TreeNode;

public class lc543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 后序遍历
        if(root==null) return 0;
        int rootDep = postorder(root);

        return res;
    }

    private int postorder(TreeNode root){
        if(root==null) return 0;
        int dep = 1;

        int depLeft = postorder(root.left);
        int depRight = postorder(root.right);
        if(depLeft+depRight>res) res = depLeft+depRight;
        return dep+Math.max(depLeft, depRight);


    }

}
