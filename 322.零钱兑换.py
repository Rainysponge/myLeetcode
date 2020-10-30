#
# @lc app=leetcode.cn id=322 lang=python3
#
# [322] 零钱兑换
#

# @lc code=start
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        m = len(coins)
        dp = [float(inf) for _ in range(amount+1)]
        dp[0] = 0
        for i in range(amount+1):
            for j in range(m):
                if coins[j]<=i:
                    dp[i] = min(dp[i], dp[i-coins[j]] + 1)
        return dp[-1] if dp[-1] <= amount else -1

# @lc code=end

