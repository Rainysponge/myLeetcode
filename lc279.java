package LC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lc279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
//        Scanner scanner = new Scanner(System.in);
        List<Integer> PS = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(IsPerfectSquare(i)){
                dp[i] = 1;
                PS.add(i);
            }else{
                dp[i] = Integer.MAX_VALUE / 2;
            }
        }

        if(dp[n]==1) return 1;

        for(int i=1; i<=n; i++){
            if(dp[i] == 1){
                continue;
            }
            for(int each : PS){
                if(i-each>0){
                    dp[i] = Math.min(dp[i], dp[i-each] + 1);
                }
            }

        }
        return dp[n];

    }

    boolean IsPerfectSquare(int x){
        double t = Math.sqrt(x);
        return (int) t*t == x;
    }
}
