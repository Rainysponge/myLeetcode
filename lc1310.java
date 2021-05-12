package LC;

public class lc1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int N = queries.length;
        int M = arr.length;
        int[] res = new int[N];
        // 暴力应该过不了  试试前缀和
        int[] before = new int[M+1];
        before[0] = 0;
        // before[i] 表示前i-1个数的异或
        for(int i=1; i<=M; i++){
            before[i] = before[i-1] ^ arr[i-1];
        }
        for(int i=0; i<N; i++){
            res[i] = before[queries[i][0]] ^ before[queries[i][1]];
        }
        return res;

    }
}
