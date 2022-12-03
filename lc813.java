public class lc813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int N = nums.length;
        double[][] dp = new double[N+1][k+1];
        double[] pre = new double[N+1];
        for(int i=0; i<N; i++){
            pre[i+1] = pre[i] + nums[i];
        }

        for(int i=1; i<=N; i++){
            dp[i][1] = pre[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= N; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (pre[i] - pre[x]) / (i - x));
                }
            }
        }
        return dp[N][k];
    }
}
