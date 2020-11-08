#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#

# @lc code=start
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # if not matrix:
        #     return 0
        # m = len(matrix)
        # n = len(matrix[0])
        # dp = [[0 for _ in range(n)] for _ in range(m)]
        # for i in range(m):
        #     for j in range(n):
        #         if i == 0 or j == 0:
        #             dp[i][j] = int(matrix[i][j])
        #         else:
        #             if matrix[i][j] == 0:
        #                 dp[i][j] = 0
        #             else:
        #                 dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
        # return max(map(max, dp)) ** 2

        if not matrix: return 0
        M = len(matrix)
        N = len(matrix[0])
        dp = [[0] * N for _ in range(M)]
        for i in range(M):
            dp[i][0] = int(matrix[i][0])
        for j in range(N):
            dp[0][j] = int(matrix[0][j])
        for i in range(1, M):
            for j in range(1, N):
                if int(matrix[i][j]) == 1:
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
        return max(map(max, dp)) ** 2

# @lc code=end

