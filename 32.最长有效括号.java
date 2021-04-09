/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null) return 0;
        int res = 0;
        int sLength = s.length();
        int[] dp = new int[sLength];
        for(int i=sLength-2; i>=0;i--){
            int tmp = dp[i+1] + i + 1;
            if(s.charAt(i)=='(' && tmp<sLength && s.charAt(tmp)==')' ){
                dp[i] = dp[i+1] + 2;
                if(tmp+1 < sLength) dp[i] += dp[tmp+1];


            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

