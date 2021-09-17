package LC;

import java.util.Deque;
import java.util.LinkedList;

public class lc513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode res = root;

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            boolean f = true;
            for(int i=0; i<l; i++){
                TreeNode tmp = queue.poll();

                if(f){
                    // left
                    if(tmp.left != null){
                        res = tmp.left;
                        f = false;
                    }else if(tmp.right != null){
                        res = tmp.right;
                        f = false;
                    }
                }
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }

        return res.val;
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
