#
# @lc app=leetcode.cn id=174 lang=python3
#
# [174] 地下城游戏
#

# @lc code=start
class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        if not dungeon or not dungeon[0]:
            return 1

        m = len(dungeon)
        n = len(dungeon[0])

        dp = [[float('inf')] * (n+1) for _ in range(m+1)]

        # 初始化值
        dp[m-1][n] = 1
        dp[m][n-1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                dp[i][j] = max(min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j], 1)
        
        return dp[0][0]                
        

# @lc code=end

