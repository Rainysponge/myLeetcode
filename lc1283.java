package LC;

public class lc1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int Min = 1;
        int Max = - Integer.MAX_VALUE / 2;
        int N = nums.length;
        for (int num : nums) {
            // Min = Math.min(Min, num);
            Max = Math.max(Max, num);
        }

        int mid = (Min + Max) / 2;
        while(Min < Max){
            if(check(mid, threshold, nums)){
                Max = mid;
                // System.out.println("Max=" + Max);
            }else{
                Min = mid + 1;
                // System.out.println("Min=" + Min);
            }
            mid = (Min + Max) / 2;
        }

        return Min;

    }

    boolean check(int t, int threshold, int[] nums){
        int res = 0;
        for(int num: nums){
            if(num % t == 0){
                res += num / t;
            }else{
                res += num / t + 1;
            }
        }

        return res <= threshold;
    }

}
