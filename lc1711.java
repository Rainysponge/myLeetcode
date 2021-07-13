package LC;

import java.util.HashMap;
import java.util.Map;

public class lc1711 {
    public int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int N = deliciousness.length;
        int maxVal = 0;
        for(int each: deliciousness){
            maxVal = Math.max(each, maxVal);
        }
        maxVal *= 2;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxVal; sum = sum << 1) {
                int count = map.getOrDefault(sum - val, 0);
                res = (res + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return res;

    }
}
