#
# @lc app=leetcode.cn id=357 lang=python3
#
# [357] 计算各个位数不同的数字个数
#

# @lc code=start
class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        n = min(n, 10)
        dp = [1] + [9]*n

        for k in range(2, n+1):
            for i in range(9, 9-k+1, -1):
                dp[k] *= i

        return sum(dp)
# @lc code=end

