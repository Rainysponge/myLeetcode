#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#

# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        # 最快
        # m, n = len(obstacleGrid), len(obstacleGrid[0])
        # dp = [[0] * n for _ in range(m)]
        # if obstacleGrid[0][0] == 0:
        #     dp[0][0] = 1
        # for i in range(m):
        #     for j in range(n):
        #         if obstacleGrid[i][j] == 0:
        #             if i == j == 0:
        #                 continue
        #             else:
        #                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        #                 # 此时假设i==0而j!=0，但是由于i-1=-1，即最后一行中的
        #                 # 数据——0（先前初始化的），所以不影响整体，可以减少判
        #                 # 断
        # return dp[m - 1][n - 1]



        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0 for _ in range(n)]for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    continue
                else:
                    if i == j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1] 


# @lc code=end

