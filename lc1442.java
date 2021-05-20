package LC;

public class lc1442 {
    public int countTriplets(int[] arr) {
        int N = arr.length;
        int res = 0;
        int[] sumList = new int[N+1];

        sumList[0] = 0;

        for(int i=1; i<N; i++){
            sumList[i] = sumList[i-1] ^ arr[i-1];  // 前缀和
        }

        for(int i=0; i<N-1; i++){
            // 遍历每一个
            for(int j=i+1; j<N; j++){
                int pre = sumList[i] ^ sumList[j+1];
                for(int k=j; k<N; k++){
                    int after = sumList[j] ^ sumList[k+1];
                    if(after == pre) res++;
                }
            }


        }

        return res;



    }
}
