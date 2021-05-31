package LC;

import java.util.HashMap;
import java.util.Map;

public class lc1553 {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        //在任意一次操作 2 之前最多只会有 1 次操作 1；
        //对于任意的橘子数 i ≥2，唯一的操作方法是将 n 通过操作 1 减少到最近的 2 的倍数，随后进行一次操作 2
        //在任意一次操作 3 之前最多只会有 2 次操作 1
        //对于任意的橘子数 i ≥3，唯一的操作方法是将 n 通过操作 1 减少到最近的 3 的倍数，随后进行一次操作 3
        return memo.get(n);
    }
}
