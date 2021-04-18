package LC;
//
// 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
// 返回获得利润的最大值。

public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[][] dp = new int[2][2]; // [][手上股票数]

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int old = 0, now = 1;
        for(int i=1; i<N; i++){
            dp[now][0] = Math.max(dp[old][0], dp[old][1] + prices[i] - fee);
            dp[now][1] = Math.max(dp[old][1], dp[old][0] - prices[i]);
            int t = now;
            now = old;
            old = t;
        }
        return Math.max(dp[0][0], dp[1][0]);
    }
}
