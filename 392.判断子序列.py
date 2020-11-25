#
# @lc app=leetcode.cn id=392 lang=python3
#
# [392] 判断子序列
#

# @lc code=start
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if s and not t :
            return False
        if not s:
            return True
        for i in range(len(t)):
            if s and t[i] == s[0]:
                s = s[1:]
        return s == ''
                
# @lc code=end

