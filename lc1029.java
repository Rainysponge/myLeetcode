package LC;

import java.util.Arrays;
import java.util.Comparator;

public class lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        // greedy
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int res = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; ++i) res += costs[i][0] + costs[i + n][1];
        return res;


    }
}
