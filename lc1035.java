package LC;

public class lc1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        int[][] dp = new int[N1+1][N2+1];
        // dp[0][0] = 0;
        for(int i=1; i<=N1; i++){
            int num1 = nums1[i-1];
            for(int j=1; j<=N2; j++){
                int num2 = nums2[j-1];
                if(num2 == num1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[N1][N2];

    }
}
