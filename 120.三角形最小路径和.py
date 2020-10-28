#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if  not triangle or not triangle[0]:
            return 0
        m = len(triangle)
        
        dp = [[0 for _ in range(m)]for _ in range(m)]
        for i in range(m):
            for j in range(i+1):
                if i == j == 0:
                    dp[i][j] = triangle[0][0]
                else:
                    if j == 0:
                        dp[i][j] = triangle[i][j] + dp[i-1][j]
                    elif j == i:
                        dp[i][j] = triangle[i][j] + dp[i-1][j-1]
                    else:
                        dp[i][j] = triangle[i][j] + min(dp[i-1][j],dp[i-1][j-1])
        return min(dp[-1])

# @lc code=end

