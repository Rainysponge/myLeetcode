package LC;

import java.util.HashMap;
import java.util.Map;

public class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // 前缀和
        int N = nums.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + nums[i];

        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+goal, count.getOrDefault(x+goal, 0) + 1);
        }

        return ans;

    }
}
