#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#

# @lc code=start
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # 与63 62 类似
        m = len(grid)
        n = len(grid[0])
        dp = [[0 for _ in range(n)]for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i == j == 0:
                    dp[i][j] = grid[0][0]
                elif i == 0:
                    dp[i][j] = grid[i][j] + dp[i][j-1]
                elif j == 0:
                    dp[i][j] = grid[i][j] + dp[i-1][j]
                else:
                    dp[i][j] = grid[i][j] + min(dp[i][j-1], dp[i-1][j])
        return dp[-1][-1]



# @lc code=end

