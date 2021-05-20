package LC;
import dataStructure.TreeNode;

import javax.swing.tree.TreeCellRenderer;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lc993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int deepX = -1, deepY = -2, deep;

        Map<TreeNode, Integer> dic = new HashMap<>();
        Deque<TreeNode> queue = new LinkedList<>();
        dic.put(root, 0);
        queue.add(root);
        int turn = 0;  // 循环次数
        int turnX = -1, turnY = -2;
        while(!queue.isEmpty()){
            turn++;
            TreeNode tmp = queue.poll();
            deep = dic.get(tmp);

            if(root.left != null){
                dic.put(root.left, deep+1);
                queue.add(root.left);
                if(root.left.val == x) {
                    deepX = deep + 1;
                    turnX = turn;
                }
                if(root.left.val == y) {
                    deepY = deep + 1;
                    turnY = turn;
                }
            }
            if(root.right != null){
                dic.put(root.right, deep+1);
                queue.add(root.right);
                if(root.right.val == x) {
                    deepX = deep + 1;
                    turnX = turn;
                }
                if(root.right.val == y) {
                    deepY = deep + 1;
                    turnY = turn;
                }
            }

            if(deepX == deepY) break;


        }

        return deepX == deepY && turnX != turnY;

    }
}
