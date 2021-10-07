package LC;

public class lc583 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=0; i<=l1; i++){
            dp[i][0] = i;
        }
        for(int i=0; i<=l2; i++){
            dp[0][i] = i;
        }


        for(int i=1; i<=l1; i++){
            char c1 = word1.charAt(i-1);
            for(int j=1; j<=l2; j++){
                char c2 = word2.charAt(j-1);

                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }

            }
        }

        return dp[l1][l2];
    }
}
