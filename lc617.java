package LC;
import dataStructure.TreeNode;

import java.util.*;

public class lc617 {
    TreeNode root = new TreeNode();
    // 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {




        return Postorder(root1, root2);


    }

    private TreeNode Postorder(TreeNode root1, TreeNode root2){
        if(root1==null) return root2;
        if(root2==null) return root1;

        TreeNode merge = new TreeNode(root1.val+root2.val);
        merge.left = Postorder(root1.left, root2.left);
        merge.right = Postorder(root1.right, root2.right);
        return merge;



    }






}
