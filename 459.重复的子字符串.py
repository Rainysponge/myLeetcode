#
# @lc app=leetcode.cn id=459 lang=python3
#
# [459] 重复的子字符串
#

# @lc code=start
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        # n = len(s)
        # for i in range(1, n//2+1):
        #     if n % i == 0:
        #         if all(s[j]==s[j-i] for j in range(i, n)):
        #             return True
        
        # return False
        n = len(s)
        for i in range(1, n//2+1):
            if n % i == 0:
                if all(s[j]==s[j-i] for j in range(1, n)):
                    return True
        return False
# @lc code=end

