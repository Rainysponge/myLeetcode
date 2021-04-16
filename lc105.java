package LC;
import com.sun.source.tree.Tree;
import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
public class lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }

        int preLen = preorder.length, inLen = inorder.length;
        TreeNode head = new TreeNode(preorder[0]);
        Map<Integer, Integer> dic = new HashMap<>();
        for(int i=0; i<inLen; i++){
            dic.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preLen-1, dic, 0, inLen-1);



    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight,
                              Map<Integer, Integer> dic, int inLeft, int inRight){
        if(preLeft > preRight||inLeft > inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = dic.get(rootVal);

        root.left = buildTree(preorder, inorder,preLeft+1, pIndex-inLeft+preLeft, dic, inLeft, pIndex-1);
        root.right = buildTree(preorder, inorder, pIndex-inLeft+preLeft+1, preRight, dic, pIndex+1, inRight);
        return root;




    }

}
