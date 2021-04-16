package LC;
//根据一棵树的中序遍历与后序遍历构造二叉树。
import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length, postLen = postorder.length;
        if(inLen==0) return null;

        Map<Integer, Integer> dic = new HashMap<>();
        for(int i=0; i<inLen; i++){
            dic.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, postLen-1, dic, 0, inLen-1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> dic,
                              int inLeft, int inRight){
        if(inLeft > inRight || postLeft > postRight) return null;
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = dic.get(rootVal);


        root.left = buildTree(inorder, postorder, postLeft, pIndex-1-inLeft+postLeft, dic, inLeft, pIndex-1);
        root.right = buildTree(inorder, postorder, postRight + inLeft-pIndex, postRight-1, dic, pIndex+1, inRight);
        return root;



    }



}
