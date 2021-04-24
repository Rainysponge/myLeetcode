package LC;
import dataStructure.TreeNode;
public class lc226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
