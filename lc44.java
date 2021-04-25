package LC;

public class lc44 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];  // [i][j] 表示s前 i个字符能和p前j个字符匹配

        dp[0][0] = true;
        for(int i=1; i<=sLen; i++){
            dp[i][0] = false;
        }

        for(int i=0; i<=sLen; i++){
            for(int j=1; j<=pLen; j++){
                if(p.charAt(j-1)=='*'){
                    if(i>0){
                        dp[i][j] |= dp[i-1][j];


                        dp[i][j] |= dp[i][j-1]; // ********** 这里没想明白，可惜了



                    }else{
                        if(j==1){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i][j-1];
                        }

                    }
                }else{
                    if(i==0){
                        dp[i][j] = false;
                    }else{
                        // ? isLetter
                        if(p.charAt(j-1)=='?'){
                            dp[i][j] = dp[i-1][j-1];
                        }else{
//                            if()
                            dp[i][j] = s.charAt(i-1) == p.charAt(j-1) && dp[i-1][j-1];
                        }
                    }
                }
            }
        }

        for(int i=0; i<=sLen; i++){
            for(int j=0; j<=pLen; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("");
        }

        return dp[sLen][pLen];





    }
}
