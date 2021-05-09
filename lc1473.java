package LC;

import java.util.Arrays;

public class lc1473 {
    static final int INF = Integer.MAX_VALUE / 2;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target];
        // 设dp(i,j,k) 表示将 [0, i][0,i] 的房子都涂上颜色，
        // 最末尾的第 i 个房子的颜色为 j，并且它属于第 k 个街区时，需要的最少花费。
        for(int i=0; i<m; i++){
            houses[i]--;
            // Init 使还未上色的房子值为-1
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(houses[i] != -1 && houses[i] != j){
                    continue; // 当此时房子已经被上色， 且要上的颜色不是指定颜色
                }
                for(int k=0; k<target; k++){
                    for(int j0 = 0; j0<n; j0++){
                        if(j==j0){
                            // 和i-1房子的颜色相同
                            if(i==0){
                                if(k==0){
                                    dp[i][j][k] = 0;
                                }
                            }else{
                                dp[i][j][k] = Math.min(dp[i][j][k],dp[i-1][j][k]);
                            }
                        }else if(i>0 && k>0){
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j0][k-1]);
                        }
                    }
                    if(dp[i][j][k] != INF && houses[i]==-1){
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }
        int res = INF;
        for(int j=0; j<n; j++){
            res = Math.min(res, dp[m-1][j][target-1]);
        }
        return res == INF ? -1 : res;
    }
}
