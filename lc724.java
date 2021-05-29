package LC;

public class lc724 {
    public int pivotIndex(int[] nums) {
        int N = nums.length;
        int[] sumPre = new int[N+1];
        sumPre[0] = 0;
        for(int i=1; i<N+1; i++){
            sumPre[i] = sumPre[i-1] + nums[i-1];
        }

//        if(sumPre[0] == 0){
//            return 0;
//        }
//        if(sumPre[N-1]==0){
//            return N-1;
//        }
        for(int i=0; i<N; i++){
            if(sumPre[i] == sumPre[N] - sumPre[i+1]){
                return i;
            }
        }
        return -1;
    }
}
