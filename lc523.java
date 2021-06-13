package LC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        if(N < 2) return false;
        Map<Integer, Integer> dic = new HashMap<>();
        int Sum = 0;
        dic.put(0, -1);
        // (余数 : 位置)
        for(int i=0; i<N; i++){
            Sum = (Sum + nums[i]) % k;
            if(dic.containsKey(Sum) && i - dic.get(Sum) >= 2) return true;
            if(!dic.containsKey(Sum))
                dic.put(Sum, i);
        }

        return false;
    }
}
