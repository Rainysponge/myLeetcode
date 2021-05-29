package LC;

public class lc664 {
    public int strangePrinter(String s) {
        char[] s1 = s.toCharArray();
        int N = s1.length;
        int[][] dp = new int[N][N];
        for(int i=0; i<N; i++){
            dp[i][i] = 1;
        }

        // 为了保证动态规划的计算过程满足无后效性，在实际代码中，
        // 我们需要改变动态规划的计算顺序，从大到小地枚举 i，并从小到大地枚举 j，
        for (int i=N-1; i>=0; i--){
            for(int j=i+1; j<N; j++){
                if(s1[i] == s1[j]){
                    dp[i][j] = dp[i][j-1];
                }else{
                    int Min = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        Min = Math.min(Min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = Min;
                }
            }
        }

        return dp[0][N-1];
    }
}
