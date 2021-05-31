package LC;

public class lc712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        int N1 = s11.length;
        int N2 = s22.length;
        int[][] dp = new int[N1+1][N2+1];
//        dp[N1][N2] = 0;
        ;
        for(int i=N1-1; i>=0; i--){
            dp[i][N2] = dp[i+1][N2] + s11[i];
        }
        for(int i=N2-1; i>=0; i--){
            dp[N1][i] = dp[N2][i+1] + s22[i];
        }
        for(int i=N1-1; i>=0; i--){
            for(int j=N2-1; j>=0; j--){
                if(s11[i] == s22[j]){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j] + s11[i], dp[i][j+1] + s22[j]);
                }
            }
        }



        for(int i=0; i<N1+1; i++){
            for(int j=0; j<N2+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
        return dp[0][0];
    }
}
