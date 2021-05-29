package LC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1787 {
    int MAX = 1 << 10;  // x的范围
    int INF = Integer.MAX_VALUE / 2;
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAX];
        Arrays.fill(f, INF);
        f[0] = 0;

        for(int i=0; i<k; i++){
            Map<Integer, Integer> dic = new HashMap<>();
            int size = 0;
            for(int j=i; j<n; j+=k){
                dic.put(nums[j], dic.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAX];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < MAX; ++mask) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
                    int x = entry.getKey(), countx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < MAX; ++j) {
                g[j] += size;
            }
            f = g;


        }
        return f[0];
    }
}
