package LC;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

public class lc123 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N][3][2]; // [第i股票][买了几手][状态]
        dp[0][1][0] = dp[0][1][1] = -Integer.MAX_VALUE/2;   //不可能
                                                            // /2 避免因为 -prices[i] 而变为正数
        dp[0][2][0] = dp[0][2][1] = -Integer.MAX_VALUE/2;   //不可能
        for(int i=0; i<N; i++){
            // init
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[i];
            dp[i][2][1] = -Integer.MAX_VALUE/2;
        }
        //未持股，未卖出过股票：说明从未进行过买卖，利润为0
        //dp[i][0][0]=0
        //未持股，卖出过1次股票：可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
        //dp[i][0][1]=max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
        //未持股，卖出过2次股票:可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
        //dp[i][0][2]=max(dp[i-1][1][1]+prices[i],dp[i-1][0][2])
        //持股，未卖出过股票：可能是今天买的，也可能是之前买的（昨天也持股）
        //dp[i][1][0]=max(dp[i-1][0][0]-prices[i],dp[i-1][1][0])
        //持股，卖出过1次股票：可能是今天买的，也可能是之前买的（昨天也持股）
        //dp[i][1][1]=max(dp[i-1][0][1]-prices[i],dp[i-1][1][1])
        //持股，卖出过2次股票：最多交易2次，这种情况不存在
        //dp[i][1][2]=float('-inf')

        for(int i=1; i<N; i++){
            for(int k=1; k<=2; k++){
                dp[i][k][0] = Math.max(dp[i-1][k-1][1]+prices[i],dp[i-1][k][0]);
                dp[i][k-1][1] = Math.max(dp[i-1][k-1][0]-prices[i], dp[i-1][k-1][1]);

            }

        }
        int res = Math.max(dp[N-1][2][0], dp[N-1][1][0]);
        return Math.max(res, 0);

    }
}
