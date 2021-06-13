package LC;

import java.util.HashMap;
import java.util.Map;

public class lc474 {
    //给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    //请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
    //如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N+1][m+1][n+1];
        Map<Integer, int[]> dic = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            int[] tmp = new int[]{0, 0};
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    tmp[0]++;
                }else{
                    tmp[1]++;
                }
            }
            dic.put(i, tmp);
        }

        for(int i=1; i<=N; i++){
            int[] tmp = dic.get(i-1);
            for(int j=0; j<m; j++){
                for(int k=0; k<n; k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j - tmp[0]>=0 && k-tmp[1] >= 0){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - tmp[0]][k-tmp[1]] + 1);
                    }
                }
            }
        }


        return dp[N][m][n];
    }
}
