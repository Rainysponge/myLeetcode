package LC;
import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lc437 {
    int count = 0;
    long[] val = new long[3]; // [leftVal, rightVal, val]
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> dic = new HashMap<>();
        // 存节点的前缀和
        preorder(root, 0, dic, targetSum);



        return count;
    }

    public void preorder(TreeNode root, int curSum, Map<Integer, Integer> dic, int targetSum){
        // 前序遍历
        if(root == null) return;
        curSum += root.val;
        count += dic.getOrDefault(curSum-targetSum, 0);
        dic.put(curSum, dic.getOrDefault(curSum-targetSum, 0) + 1);

        preorder(root.left, curSum, dic, targetSum);
        preorder(root.right, curSum, dic, targetSum);
        dic.put(curSum, dic.get(curSum) -1);
    }

}
