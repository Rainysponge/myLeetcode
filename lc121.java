package LC;

import java.util.Deque;
import java.util.LinkedList;

//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

public class lc121 {
    public int maxProfit(int[] prices) {
        // 单调递增栈
//        Deque<Integer> stack = new LinkedList<>();
//        int N = prices.length;
//        int res = 0;
//        int buy = 0;
//        for(int i=0; i<N; i++){
//            if(stack.isEmpty()){
//                stack.push(prices[i]);
//                buy = prices[i];
//                continue;
//            }
//
//            while(!stack.isEmpty() && stack.peek() > prices[i]){
//                int sell = stack.pop();
//                res = Math.max(res, sell - buy);
//            }
//            if(stack.isEmpty()) buy = prices[i];
//            stack.push(prices[i]);
//        }
//        if(!stack.isEmpty()){
//            res = Math.max(res, stack.peek() - stack.getLast());
//
//        }
//        return res;

        // dp
        int N = prices.length;
        int[][] dp = new int[N][2]; // 0买入 1卖出
        dp[0][0] = prices[0];
        dp[0][1] = 0;

        for(int i=1; i<N; i++){
            for(int j=0; j<2; j++){
                if(j==0) dp[i][j] = Math.min(prices[i], dp[i-1][j]);
                if(j==1) dp[i][j] = Math.max(prices[i] - dp[i-1][0], dp[i-1][j]);
            }
        }
        return dp[N-1][1];




    }
}
