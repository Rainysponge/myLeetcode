package LC;
import dataStructure.TreeNode;
public class lc1145 {
    int leftNum = 0, rightNum = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Count(root, x);
        int parent = n - leftNum - rightNum -1;
        int select = Math.max(Math.max(parent, leftNum), rightNum);
        return select > n - select;
    }

    private int Count(TreeNode root, int x){
        if(root==null) return 0;
        int left = Count(root.left, x);
        int right = Count(root.right, x);
        if(root.val==x){
            leftNum = left;
            rightNum = right;
        }
        return 1+left+right; // 返回该节点位根的节点总数
    }
}
