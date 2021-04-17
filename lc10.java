package LC;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//        '.' 匹配任意单个字符
//        '*' 匹配零个或多个前面的那一个元素
//        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

public class lc10 {
    public boolean isMatch(String s, String p) {
        // s--->待匹配字符串
        // p--->正则

        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];

        for(int i=0; i<=sLen; i++){
            for(int j=0; j<=pLen; j++){
                if(j==0 && i==0){
                    dp[0][0] = true;
                    continue;
                }
                if(j==0){
                    dp[i][j] = false;
                    continue;
                }

                if(p1[j-1]!='*'){
                    if(i>0 && (s1[i-1] == p1[j-1] || p1[j-1]=='.')){
                        dp[i][j] = dp[i-1][j-1];  // 这里dp中的i, j对应字符串中下标的i - 1, j - 1
                    }
                }else{
                    // p1[j-1] == '*'
                    if(j-2>=0){
                        dp[i][j] |= dp[i][j-2];
                    }
                    if(i>0 && j >= 2){
                        dp[i][j] |= dp[i-1][j] && (p1[j-2]=='.' || p1[j-2] == s1[i-1]);
                    }
                }


            }
        }
        System.out.println(dp[sLen][pLen]);
        return dp[sLen][pLen];


    }
}
