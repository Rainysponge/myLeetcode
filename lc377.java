package LC;

import java.util.Arrays;

public class lc377 {
    public int combinationSum4(int[] nums, int target) {
//        int N = nums.length;
//        int res = 0;
//        Arrays.sort(nums);
//        for(int i=0; i<N; i++){
//            if(nums[i]>target) break;
//
//            int sub = target - nums[i];
//            // 因为顺序无关，所以要让每一个小于target的元素做做tmp[0]
//            // 暴力dp
//            int[] dp = new int[sub+1];
//            dp[0] = 1;
//            for(int j=0; j<=sub; j++){
//                for (int num : nums) {
//                    if (j >= num) {
//                        dp[j] += dp[j - num];
//                    }
//                }
//
//            }
//            res += dp[sub];
//
//        }
//        return res;
        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        Arrays.sort(nums);
        for(int i=1; i<=target; i++){
            for(int num: nums){
                if(i>=num){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
