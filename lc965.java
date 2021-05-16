package LC;
import dataStructure.TreeNode;
public class lc965 {
    int num;
    boolean res = true;
    public boolean isUnivalTree(TreeNode root) {
        num = root.val;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root==null) return;
        if(num != root.val){
            res = false;
            return;
        }
        if(!res) return;

        dfs(root.left);
        dfs(root.right);
    }


}
