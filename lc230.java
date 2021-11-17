package LC;
import dataStructure.TreeNode;

public class lc230 {
    int k;
    int index = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历
        this.k = k;
        dfs(root);
        return res;

    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        index++;
        if(index == k){
            res = root.val;
            return;
        }
        dfs(root.right);

    }


}
