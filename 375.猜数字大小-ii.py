#
# @lc app=leetcode.cn id=375 lang=python3
#
# [375] 猜数字大小 II
#

# @lc code=start
class Solution:
    def getMoneyAmount(self, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for L in range(n - 1, 0, -1):
            for R in range(L + 1, n + 1):
                dp[L][R] = min(i + max(dp[L][i - 1], dp[i + 1][R]) for i in range(L, R))
        return dp[1][n]
    

# @lc code=end

