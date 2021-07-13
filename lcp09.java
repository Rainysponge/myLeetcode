package LC;

import java.util.*;

public class lcp09 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int res = 0;
    // int turn = 0;
    public int numWays(int n, int[][] relation, int k) {
        // 以下map下用于 DFS、BFS
//        int N = relation.length;
//
//        for (int[] ints : relation) {
//            List<Integer> tmp;
//            if (map.containsKey(ints[0])) {
//                tmp = map.get(ints[0]);
//            } else {
//                tmp = new ArrayList<>();
//            }
//            tmp.add(ints[1]);
//            map.put(ints[0], tmp);
//
//        }
        // dfs(0, n-1, k);





        // dp

        for(int[] each: relation){
            List<Integer> before = map.getOrDefault(each[1], new ArrayList<>());
            before.add(each[0]);
            map.put(each[1], before);
        }


        int[][] dp = new int[k+1][n];  // pd[i][j] 表示经过i次后到达j的个数
        dp[0][0] = 1;
        for(int i=1; i<=k; i++){
            for(int j=0; j<n; j++){
                // dp[i][j] = dp[i-1][k for k in map.get(j)]
                if(map.containsKey(j)){
                    List<Integer> pres = map.get(j);
                    for(int pre: pres){
                        dp[i][j] += dp[i-1][pre];
                    }
                }
            }
        }



        return dp[k][n-1];



    }

    void dfs(int s, int n, int k){
        if(k == 0){
            if(s == n) res++;
            return;
        }
        if(map.containsKey(s)){
            List<Integer> t = map.get(s);
            for(int each: t){
                dfs(each, n, k-1);
            }
        }
    }



}
