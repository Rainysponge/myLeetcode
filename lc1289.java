package LC;

public class lc1289 {
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int maxj = -1, Min = 300;
                for(int k=0; k<n; k++){
                    if(j == k) continue;

                    if(dp[i-1][k] < Min){
                        Min = dp[i-1][k];
                    }
                }
                dp[i][j] = Min + arr[i][j];
            }
        }


        int res = 300;
        for(int i=0; i<n; i++){
            res = Math.min(res, dp[m-1][i]);
        }
        return res;
    }
}
