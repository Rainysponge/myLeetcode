package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);  // 确保有序
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = 1;  //以nums[i] 为最大整数的「整除子集」的大小
                        // （在这种定义下nums[i] 必须被选择）。
        }

        int maxSize = 1;
        int maxVal = nums[0];

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        if(maxSize==1){
            res.add(nums[0]);
            return res;
        }
        for(int i=N-1; i>=0 && maxSize>0; i--){
            if(dp[i]==maxSize && maxVal%nums[i]==0){
                res.add(nums[i]);
                maxSize--;
                maxVal = nums[i];
            }
        }

        return res;
    }
}
