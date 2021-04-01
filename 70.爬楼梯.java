/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] s = new int[n+1];
        s[0] = 1;
        s[1] = 1;
        if (n < 2){
            return 1;
        }else{
            for(int i=2;i<=n;i++) s[i] = s[i-1] + s[i-2];
        }

        return s[n];
    }
}
// @lc code=end

