package LC;


public class lc375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>0; i--){
            for(int j=i+1; j<=n; j++){
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    int cost = k + Math.max(dp[1][k-1], dp[k+1][n]);
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];

    }
}
