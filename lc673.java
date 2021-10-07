package LC;

public class lc673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int max = 0;
        int res = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }

                }
            }
            if (dp[i] > max) {
                max = dp[i];
                res = cnt[i]; // 重置计数
            } else if (dp[i] == max) {
                res += cnt[i];
            }

        }
        return res;


    }
}
