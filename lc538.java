package LC;
import dataStructure.TreeNode;
//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
// 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
//

public class lc538 {
    int Sum = 0;  // 记录累加值
    public TreeNode convertBST(TreeNode root) {
        // 从右子树开始的中序遍历
        InorderFromRight(root);
        return root;

    }

    private void InorderFromRight(TreeNode root){
        if(root==null) return;
        InorderFromRight(root.right);
        Sum += root.val;
        root.val = Sum;
        InorderFromRight(root.left);


    }



}
