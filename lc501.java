package LC;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc501 {
    List<Integer> res = new ArrayList<>();
    int count = 0;
    int maxCount = 0;
    int base;
    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] ans = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        // do something
        update(root.val);
        dfs(root.right);
    }


    void update(int x){
        if(x == base){
            count++;
        }else{
            count = 1;
            base = x;
        }

        if(count == maxCount){
            res.add(base);
        }

        if(count > maxCount){
            res.clear();
            maxCount = count;
            res.add(base);
        }

    }


}
