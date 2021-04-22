package LC;

public class lc91 {
    public int numDecodings(String s) {
        char[] sChar = s.toCharArray();
        int N = sChar.length;
        if(N==0 || sChar[0]=='0'){
            return 0;
        }

        // DP
        int[] dp = new int[N+1];
        // dp第i位表示下标位0~i-1的字符有多少种编码方式

        dp[0] = 0;  // 空字符串显然没有编码方式
        dp[1] = 1;
        for(int i=2; i<N+1; i++){
            int cur = sChar[i-1] - '0';
            int pre = sChar[i-1] - '0';
            if(pre > 2 || pre == 0){
                dp[i] = dp[i-1];
            }else{
                int Sum = pre*10 + cur;
                if(Sum > 26){
                    dp[i] = dp[i-1];
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }

        }
        return dp[N];




    }
}
