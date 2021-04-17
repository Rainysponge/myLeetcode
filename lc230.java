package LC;
import dataStructure.TreeNode;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
public class lc230 {
    // 中序遍历即可
    int index = 1;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root, k);
        return ans;
    }

    public void Inorder(TreeNode root, int k){
        if(root == null) return;
        if(root.left!=null) Inorder(root.left, k);
        if(index==k) {
            ans = root.val;
//            return ans;
        }

        index++;
        if(root.right!=null) Inorder(root.right, k);



    }


}
