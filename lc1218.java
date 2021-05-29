package LC;

import java.util.HashMap;
import java.util.Map;

public class lc1218 {
    public int longestSubsequence(int[] arr, int difference) {
//        int Max = -Integer.MAX_VALUE;
//        int Min = Integer.MAX_VALUE;
//
//        for(int each: arr){
//            Max = Math.max(Max, each);
//            Min = Math.min(Min, each);
//        }
//        int capacity = Math.abs(Max) + Math.abs(Min) + 2 * Math.abs(difference) + 3;
//        int[] dp = new int[capacity];
//        int res = -1;
//
//        for(int each: arr){
//            int t = each + Math.abs(Min) + Math.abs(difference);
//            dp[t] = dp[t-difference] + 1;
//            System.out.println(dp[t]);
//            res = Math.max(dp[t], res);
//        }
//        return res;
        Map<Integer, Integer> dic = new HashMap<>();
        int res = 0;
        for(int each: arr){
            int sub = each - difference;
            int l = dic.getOrDefault(sub, 0) + 1;
//            int add = each + difference;
            res = Math.max(res, l);
            dic.put(each, l);

        }
        return res;


    }
}
