#
# @lc app=leetcode.cn id=139 lang=python3
#
# [139] 单词拆分
#

# @lc code=start
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # 递归
        # def dfs(sL):
        #     if sL in wordDict:
        #         return True
        #     for i in range(1, len(sL)):
        #         if sL[:i] in wordDict:
        #             res = dfs(sL[i:])
        #             if res:
        #                 return True
                
        #     return False
        # return dfs(s)
        # DP
        dp = [False for _ in range(len(s)+1)]
        dp[0] = True
        if s in wordDict:
            return True
        for i in range(1, len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
        return dp[-1]

# @lc code=end

