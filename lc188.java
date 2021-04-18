package LC;

public class lc188 {
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        if(N==0 || k==0) return 0;

        int[][][] dp = new int[N][k+1][2]; // [第i股票][买了几手][状态]

        for(int j=1; j<=k; j++){
            dp[0][j][1] = dp[0][j][0] = -Integer.MAX_VALUE/2;
        }

        for(int i=0; i<N; i++){
            // init
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[i];
            dp[i][k][1] = -Integer.MAX_VALUE/2;
        }


        for(int i=1; i<N; i++){
            for(int j=1; j<=k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j-1][1]+prices[i],dp[i-1][j][0]);
                dp[i][j-1][1] = Math.max(dp[i-1][j-1][0]-prices[i], dp[i-1][j-1][1]);

            }

        }
        int res = 0;
        for(int j=1; j<=k; j++){
            res = Math.max(res, dp[N-1][j][0]);
        }
        return Math.max(res, 0);
    }
}
