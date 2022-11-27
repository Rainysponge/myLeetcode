public class lc1752 {
    public boolean check(int[] nums) {
        int N = nums.length;
        int cur = 0;
        for(int i=1; i<N; i++){
            if (nums[i] < nums[i-1]){
                cur = i;
                break;
            }
        }

        if(cur == 0){
            return true;
        }
        for(int i=cur+1; i<N;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return nums[N-1] <= nums[0];
    }
}
