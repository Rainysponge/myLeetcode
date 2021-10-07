package LC;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class lc437 {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // 后序遍历 哈希
        postOrder(root,targetSum);
        return res;
    }

    Map<Integer, Integer> postOrder(TreeNode root, int targetSum){
        Map<Integer, Integer> resMap = new HashMap<>();
        if(root == null){

            return resMap;
        }

        Map<Integer, Integer> leftMap = postOrder(root.left, targetSum);
        Map<Integer, Integer> rightMap = postOrder(root.right, targetSum);

        for(Map.Entry<Integer, Integer> entry: rightMap.entrySet()){
            leftMap.put(entry.getKey(), leftMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        // leftMap.putAll(rightMap);


        leftMap.put(0, leftMap.getOrDefault(0, 0) + 1);

        for(Map.Entry entry : leftMap.entrySet()){
            int num = (int)entry.getKey();

            resMap.put(num + root.val,
                    leftMap.get(num));


        }
        if(resMap.containsKey(targetSum)){
            System.out.println(root.val);
            res += resMap.get(targetSum);
        }


        return resMap;

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
