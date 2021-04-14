package LC;

public class lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
       // 用dp[i][j]来表示是否能用s1[:i]和s2[:j]来表示s3[:i+j]
        int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();
        if(s1Len + s2Len != s3Len){
            return false;
        }

        boolean[][] dp = new boolean[s1Len+1][s2Len+1];
        dp[0][0] = true;

        for(int i=0;i<=s1Len;i++){
            for(int j=0;j<=s2Len;j++){
                int p = i + j - 1;
                if(i>0){
                    dp[i][j] |= dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p);
                }
                if(j>0){
                    dp[i][j] |= dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p);
                }
            }
        }

        return dp[s1Len][s2Len];


    }
}
