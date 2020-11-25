#
# @lc app=leetcode.cn id=292 lang=python3
#
# [292] Nim 游戏
#

# @lc code=start
class Solution:
    def canWinNim(self, n: int) -> bool:
        # if n <= 3:
        #     return True
        # dp = [False for _ in range(n+1)]
        # dp[1], dp[2], dp[3] = True, True, True
        # # dp[4] = False
        # for i in range(4, n+1):
        #     if False in (dp[i-1], dp[i-2],dp[i-3]):
        #         dp[i] = True
        # return dp[-1]
        return n % 4 != 0
# @lc code=end

