package LC;

public class lc645 {
    public int[] findErrorNums(int[] nums) {
        int N = nums.length;
        int[] counter = new int[N+1];

        int Sum = 0, SumN = 0;
        int repeat = -1;
        for(int i=0; i<N; i++){
            Sum = Sum ^ nums[i];
            SumN = SumN ^ (i+1);
            counter[nums[i]]++;
            if(counter[nums[i]]>1){
                repeat = nums[i];
            }
        }
        int[] res = new int[2];
        res[0] = repeat;
        res[1] = SumN ^ Sum ^ repeat;
        return res;


    }
}
