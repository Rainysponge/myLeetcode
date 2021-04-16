package LC;

import java.util.HashMap;
import java.util.Map;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        // 暴力
        int N = nums.length;
        int[] Sum = new int[N+1];
        Sum[0] = 0;
        Sum[1] = nums[0];
        for(int i=2; i<=N; i++){
            Sum[i] = Sum[i-1] + nums[i-1];
        }

        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i=1; i<=N; i++){
            for(int j=i-1; j>=0; j--){
                if(Sum[i] - Sum[j] == k){
                    res++;
                }
            }
        }
//        for(int i=1; i<N; i++){
//
//        }
        return res;

    }
}
