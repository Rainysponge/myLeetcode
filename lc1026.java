package LC;
import dataStructure.TreeNode;
public class lc1026 {
//    int res = -1;
//    public int maxAncestorDiff(TreeNode root) {
//        // 节点与其祖先之间的最大差值
//
//        dfs(root);
//        return res;
//    }
//
//    public int[] dfs(TreeNode root){
//        int[] nums = new int[2];
//        int[] preLeft = new int[2];
//        int[] preRight = new int[2];
//        // nums[0] 为最大值， nums[1] 为最小值
//        if(root==null) return new int[]{-Integer.MAX_VALUE, Integer.MAX_VALUE};
//        preLeft = dfs(root.left);
//        preRight = dfs(root.right);
//
//
//
//
//        for(int i=0; i<2; i++){
//            if(res < Math.abs(root.val-preLeft[i])){
//                res = Math.abs(root.val-preLeft[i]);
//            }
//            if(res < Math.abs(root.val-preRight[i])){
//                res = Math.abs(root.val-preRight[i]);
//            }
//        }
//
//        nums[0] = Math.max(preLeft[0], preRight[0]);
//        nums[1] = Math.min(preLeft[1], preRight[1]);
//        return nums;
//    }
    public int maxAncestorDiff(TreeNode root) {
        int left = maxAncestorDiff(root.left, root.val, root.val);
        int right = maxAncestorDiff(root.right, root.val, root.val);
        return Math.max(left, right);
    }

    public int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        if (root.val > max) {
            max = root.val;
        } else if (root.val < min) {
            min = root.val;
        }
        if (root.left == null && root.right == null) {
            return max - min;
        }
        int left = maxAncestorDiff(root.left, max, min);
        int right = maxAncestorDiff(root.right, max, min);
        return Math.max(left, right);
    }

}