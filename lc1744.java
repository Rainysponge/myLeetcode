package LC;

public class lc1744 {
    //queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]
//    public boolean[] canEat(int[] candiesCount, int[][] queries) {
//        int N = queries.length;
//        boolean[] res = new boolean[N];
//        for(int i=0; i<N; i++){
//            int[] t = Earliest(candiesCount, queries[i]);
//            res[i] = t[queries[i][0]] <= queries[i][1];
//        }
//
//        for(int i=0; i<N; i++){
//            System.out.print(res[i] + " ");
//        }
//
//
//        return res;
//    }
//
//    int[] Earliest(int[] candiesCount, int[] query){
//        int N = candiesCount.length;
//        int[] res = new int[N];
//        res[0] = 1;
////        int sum = 0;
//        int day = 1, index = 1;
//        while(candiesCount[N-1] > 0 && index <= query[0]){
//            if(candiesCount[index-1] - query[2] < 0){
//                res[index] = day;
//                candiesCount[index] = candiesCount[index] + candiesCount[index-1] - query[2];
//                index++;
//            }else{
//                candiesCount[index-1] = candiesCount[index-1] - query[2];
//            }
//            day++;
//
//        }
//        return res;
//    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // 前缀和
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }

}
