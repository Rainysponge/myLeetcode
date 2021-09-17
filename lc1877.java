package LC;

import java.util.Arrays;

public class lc1877 {
    public int minPairSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);


        int res = -1;


        for(int i=0; i<N/2; i++){
            res = Math.max(res, nums[i] + nums[N-1-i]);
        }
        return res;

    }
}
