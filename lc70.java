package LC;

import java.util.ArrayList;

public class lc70 {
    public int climbStairs(int n) {
        int[] s = new int[n+1];
        s[0] = 1;
        s[1] = 1;
        if (n < 2){
            return 1;
        }else{
            for(int i=2;i<=n;i++) s[i] = s[i-1] + s[i-2];
        }

        return s[n];
    }
}
