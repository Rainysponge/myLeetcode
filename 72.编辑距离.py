#
# @lc app=leetcode.cn id=72 lang=python3
#
# [72] 编辑距离
#

# @lc code=start
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # 递归法，在case26出现Time Limit Exceeded
        # L1, L2 = len(word1), len(word2)

        # def dp(i, j):
        #     if i == -1:
        #         return j + 1
        #     if j == -1:
        #         return i + 1

        #     if word1[i] == word2[j]:
        #         return dp(i-1, j-1)
        #     else:
        #         return min(
        #                     dp(i-1, j) + 1,
        #                     dp(i, j-1) + 1,
        #                     dp(i-1, j-1) + 1
        #                 )
        #         # 增   删     改（替换）
        # return dp(L1-1, L2-1)
        
        # 记忆递归法
        m = len(word1)
        n = len(word2)
        dp = [[0 for _ in range(n+1)]for _ in range(m+1)]
        for i in range(m+1):
            dp[i][0] = i
        for j in range(n+1):
            dp[0][j] = j
        # 以上为初始化数据,在第一行或者第一列显然更改为上次的+1次
        
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word2[j-1] == word1[i-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(
                                    dp[i-1][j] + 1,
                                    dp[i][j-1] + 1,
                                    dp[i-1][j-1] + 1,
                                )

        return dp[-1][-1]






# @lc code=end

