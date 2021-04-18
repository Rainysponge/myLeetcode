package LC;
import dataStructure.TreeNode;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class lc236 {
    TreeNode res = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历 不会出现节点t的左右子树都是p的父节点
        if(root==null) return null;
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);

        if (root.left!=null && ((root.val == p.val &&  root.left.val== q.val) ||
                (root.val == q.val && root.left.val== p.val)))
        {
            res = root;
            return res;
        }
        if (root.right!=null && ((root.val == p.val &&  root.right.val== q.val) ||
                (root.val == q.val && root.right.val== p.val)))
        {
            res = root;
            return res;
        }
        if(root.right!=null && root.left!=null &&
                judge(root.left, p, q) && judge(root.right, p, q))

        {
            res = root;
            return res;
        }

//        if(root.right!=null && root.left!=null &&
//                ((root.right.val== q.val && root.left.val== p.val) ||
//                (root.right.val== p.val && root.left.val== q.val)))
//        {
//            res = root;
//            return res;
//        }

        if(root.left!=null && root.left.val==p.val){
            root.val = p.val;
        }
        if(root.left!=null && root.left.val==q.val){
            root.val = q.val;
        }
        if(root.right!=null && root.right.val==p.val){
            root.val = p.val;
        }
        if(root.right!=null && root.right.val==q.val){
            root.val = q.val;
        }
        return res;

//        // 验证p
//        if(root.left!=null && root.left.val == p.val) root.val = p.val;
//        if(root.right!=null && root.right.val == p.val) root.val = p.val;
//
//        // q
//        if(root.left!=null && root.left.val == q.val) root.val = q.val;
//        if(root.right!=null && root.right.val == q.val) root.val = q.val;
//
//        if(root)
    }

    private boolean judge(TreeNode root, TreeNode p, TreeNode q){
        return root.val == p.val || root.val == q.val;
    }

}
