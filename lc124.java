package LC;

public class lc124 {
        int res = 0;
        public int maxPathSum(TreeNode root) {
            if (root == null){
                return 0;
            }
            if(root.right!=null && root.left != null){
                res = maxFourNums(res, maxPathSum(root.right), maxPathSum(root.left)
                        , res + maxPathSum(root.right) + maxPathSum(root.left));
            }else  if(root.right!=null){
                res = Math.max(res, res + maxPathSum(root.right));
                res = Math.max(res, maxPathSum(root.right));
                return res;
            }else if (root.left!=null){
                res = Math.max(res, res + maxPathSum(root.left));
                res = Math.max(res, maxPathSum(root.left));
                return res;
            }else{
                return root.val;
            }



            return res;


        }
        public int maxFourNums(int a, int b, int c, int d){
            int Max = Math.max(a, b);
            Max = Math.max(Max, c);
            return Math.max(Max, d);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}