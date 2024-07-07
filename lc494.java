public class lc494 {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        helper(0,0, n, target, nums);
        return res;
    }

    public void helper(int i, int _sum, int n, int target, int[] nums){
        if (n == i){
            // 遍历到数组的最后一个
            if(_sum == target){
                res++;
            }
        }
        else{
            helper(i+1, _sum + nums[i], n, target, nums);
            helper(i+1, _sum - nums[i], n, target, nums);

        }


    }
}
