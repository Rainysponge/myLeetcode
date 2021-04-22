package LC;

import java.util.TreeSet;

public class lc363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 听说暴力可以过？
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
                for (int t = 0; t < n; ++t) {
                    System.out.print(sum[t] + " "); // 更新每列的元素和
                }
                System.out.println(" ");
            }
        }
        return ans;


    }
}
