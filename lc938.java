package LC;
import dataStructure.TreeNode;
public class lc938 {
    boolean flag = false;  // 是否找到low
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        Inorder(root, low, high);
        return res;
    }

    private void Inorder(TreeNode root, int low, int high){
        if(root==null) return;
        Inorder(root.left, low, high);

        if(root.val == low){
            flag = true;
        }
        if(flag){
            res += root.val;
        }

        if(root.val == high){
            flag = false;
        }

        Inorder(root.right, low, high);



    }


}
