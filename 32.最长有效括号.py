#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s or len(s) <= 1:
            return 0
    
        res = 0
        dp = [0 for _ in range(len(s))]
        for i in range(len(s)-2,-1,-1):
            tmp =  i + 1 + dp[i+1]
            if s[i] == '(' and tmp < len(s) and s[tmp] == ')':
                dp[i] = dp[i+1] + 2  # 把i和tmp并入 +2
                if tmp + 1 < len(s):
                    dp[i] += dp[tmp + 1]  # ")(())()"

                res = max(dp[i], res)
        return res




# @lc code=end

