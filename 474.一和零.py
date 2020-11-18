#
# @lc app=leetcode.cn id=474 lang=python3
#
# [474] 一和零
#

# @lc code=start
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for s in strs:
            count_0, count_1 = 0, 0
            for c in s:
                if c == '0':
                    count_0 += 1
                elif c == '1':
                    count_1 += 1
            for i in range(m, count_0-1, -1):
                for j in range(n, count_1-1, -1):
                    dp[i][j] = max(dp[i][j], dp[i-count_0][j-count_1]+1)
        return dp[m][n]

# @lc code=end

