package LC;
// 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

import java.util.Deque;
import java.util.LinkedList;

public class lc122 {
    public int maxProfit(int[] prices) {
        // 贪心 + 单调栈
//
        // 纯贪心 上坡即买卖 这里不赘述

        //dp
        //定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。

        int N = prices.length;
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int res = 0;
        for(int i=1; i<N; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);

        }
        return dp[N-1][0];

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
    }
}
