package LC;

import java.util.Arrays;

public class lc877 {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int half = N / 2;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][N - 1] > 0;


    }
}
