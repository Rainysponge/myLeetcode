package LC;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内
// 都藏有一定的现金。这个地方所有的房屋都 围成一圈
// ，这意味着第一个房屋和最后一个房屋是紧挨着的。同
// 时，相邻的房屋装有相互连通的防盗系统，如果两间
// 相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//给定一个代表每个房屋存放金额的非负整数数组，计算你
// 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
public class lc213 {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        int l = nums.length;
        int[] dp = new int[l];
        for(int i=0;i<l-1;i++){
            //第0个被取用
            if(i==0) {
                dp[0] = nums[0];
//                dp[l-1] = 0;
                dp[1] = nums[0];
            }else if(i>=2){
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        for(int i=0;i<l;i++){
            System.out.print(dp[i] + "\t");
        }
        System.out.println("");
        int res = dp[l-2];
        for(int i=0;i<l;i++){
            //第0个未被取用
            if(i==0) {
                dp[0] = 0;
                dp[1] = nums[1];
            }else if(i>=2){
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        for(int i=0;i<l;i++){
            System.out.print(dp[i] + "\t");
        }
        System.out.println("");
        return Math.max(res, dp[l-1]);
    }
}
