package LC;
import dataStructure.TreeNode;
public class lc687 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        // 后序
        postOrder(root, -1);
        return res;
    }

    private int postOrder(TreeNode root, int val){
        if(root == null) return 0;

        int left = postOrder(root.left, root.val);
        int right = postOrder(root.right, root.val);
        int t = -1;

        t = left + right;

        res = Math.max(res, t);

        if(root.val == val) return Math.max(left, right) + 1;
        else return 0;


    }
}
