import java.util.Arrays;

import static java.lang.Math.abs;

public class lc3115 {
    public int maximumPrimeDifference(int[] nums) {
        int res = 0;
        // 最大的数是100 所以我们直接建表
        boolean[] prime = new boolean[101];
        Arrays.fill(prime, true);
        // 建立质数表
        for(int i=2; i<=100; i++){
            if(!prime[i]){
                continue;  // 如果已经被认证是不是指数则跳过
            }

            for(int j=2; j*j<=i; j++){
                if(prime[j] && i % j == 0){
                    prime[i] = false;
                    break;
                }
            }

            if(prime[i]){
                for(int j=i*i; j<=100; j=j+i){
                    prime[j] = true;
                }
            }
        }
        int left = -1;
        int right = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                continue;
            }
            if(prime[nums[i]]){
                if(left == -1){
                    left = i;
                }
                right = i;
            }

        }

        return right - left;
    }

}
