#
# @lc app=leetcode.cn id=62 lang=python3
#
# [62] 不同路径
#

# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 排列组合 O(n)
        
        # res = 1
        # if m<n:
        #     m, n = n, m
        # for i in range(m, m+n-1):
        #     res *= i
        #     res /= i- m + 1
        # return int(res)

        # 递归 类似于上楼梯，由于方向一定，该问题的解
        # 就是其两个子问题解的和

        # dp = [[0 for _ in range(n)] for _ in range (m)]
        # for i in range(m):
        #     for j in range(n):
        #         # ac63后，回头修改过
        #         if i == j == 0:
        #             dp[i][j] = 1
        #         else:
        #             dp[i][j] = dp[i-1][j] + dp[i][j-1]
        # return dp[-1][-1]

        dp = [[0 for _ in range(n)]for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if i == j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]

# @lc code=end

