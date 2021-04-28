package LC;

import java.util.Arrays;

public class lc132 {
    public int minCut(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], true);
        }

        for(int i=N - 1; i>=0; i--){
            for(int j=i+1; j<N; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];

            }
        }

        int[] f = new int[N];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i=0; i<N; i++){
            if(dp[0][i]){
                f[i] = 0;
            }else{
                for(int j=0; j<i; j++){
                    if(dp[j+1][i]){
                        f[i] = Math.min(f[i], f[j]+1);
                    }
                }
            }
        }
        return f[N-1];
    }
}
