#
# @lc app=leetcode.cn id=140 lang=python3
#
# [140] 单词拆分 II
#

# @lc code=start
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:  
        ans, tmp = [], ''
        if s in wordDict:
            ans.append(s)
        for i in range(len(s)):
            tmp += s[i]
            if tmp in wordDict:
                if self.DP_func(s[i+1:], wordDict):
                    t = self.wordBreak(s[i+1:], wordDict)
                    for j in t:
                        ans.append(tmp+' '+j)
        return ans




    def DP_func(self, s, wordDict):
        dp = [False for _ in range(len(s)+1)]
        dp[0] = True
        for i in range(1, len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
        return dp[len(s)]           




# @lc code=end

