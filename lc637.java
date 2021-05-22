package LC;

import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> lQueue = new LinkedList<>();

        if(root==null) return res;
        queue.add(root);

        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                lQueue.add(queue.poll());  // 每层
            }

            double tmp = 0;
            double count = 0;

            while (!lQueue.isEmpty()){
                TreeNode tmpTreeNode = lQueue.poll();
                if(tmpTreeNode.left!=null) queue.add(tmpTreeNode.left);
                if(tmpTreeNode.right!=null) queue.add(tmpTreeNode.right);
                tmp += (double) tmpTreeNode.val;
                count += 1;
            }
            res.add(tmp / count);



        }


        return res;


    }
}
