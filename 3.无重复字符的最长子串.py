#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        s_len = len(s)
        start = 0
        usedchars = {}
        L = 0
        for i in range(s_len):
            if s[i] in usedchars and usedchars[s[i]] >= start:
                start = usedchars[s[i]]+1
            else:
                L = max(L, i-start+1)
            usedchars[s[i]] = i
        return L
# @lc code=end

