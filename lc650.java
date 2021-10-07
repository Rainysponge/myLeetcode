package LC;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc650 {
    public int minSteps(int n) {
//        if(n == 1) return 0;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, Integer.MAX_VALUE / 2);
//        dp[1] = 0;
//        dp[2] = 2;
//
//        for(int i=3; i<=n; i++){
//            for(int j=1; j<i; j++){
//                if(i % j == 0){
//                    dp[i] = Math.min(dp[i], dp[j] + i / j);
//                }
//            }
//        }
//
//
//        return dp[n];

        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;



    }
}
