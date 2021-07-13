package LC;

public class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int N = nums.length;
        int[] Sum = new int[N+1];
        Sum[0] = 0;
        for(int i=1; i<=N; i++){
            Sum[i] = Sum[i-1] + nums[i-1];
        }
        int res = 0;
//        for(int i=1; i<=N; i++){
//                for(int j=0; i<=i; j++){
//                int t = Sum[i] - Sum[j];
//                if(t == goal){
//                    res++;
//                }
//            }
//        }
        return res;
    }
}
