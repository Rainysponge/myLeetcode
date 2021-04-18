package LC;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
public class lc309 {
    public int maxProfit(int[] prices) {
        int N = prices.length, i;
        int[][][] dp = new int[N-1][2][2]; // [第i只股票][手上股票数][是否为冻结期]
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = -Integer.MAX_VALUE/2;
        dp[0][1][1] = -Integer.MAX_VALUE/2;
        for(i=1; i<N; i++){
            // init
            dp[i][1][1] = -Integer.MAX_VALUE/2;
        }
        for(i=1; i<N; i++){
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][0][1]);
            dp[i][0][1] = dp[i-1][1][0] + prices[i];
            dp[i][1][0] = dp[i-1][0][0] - prices[i];

        }
        return Math.max(dp[N-1][0][0], dp[N-1][0][1]);





    }
}
