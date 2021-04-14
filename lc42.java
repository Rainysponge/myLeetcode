package LC;

import java.util.Deque;
import java.util.LinkedList;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class lc42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<Integer>();

        int res = 0;
        for(int i=0; i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int curW = i - left - 1;
                int curH = Math.min(height[i], height[left]) - height[top];
                res += curH * curW;
            }
            stack.push(i);
        }
        return res;
    }
}
