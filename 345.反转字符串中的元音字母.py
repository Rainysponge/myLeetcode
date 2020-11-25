#
# @lc app=leetcode.cn id=345 lang=python3
#
# [345] 反转字符串中的元音字母
#

# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        yuan = ['a','e','i','o','u','A','E','I','O','U']
        s = list(s)
        
        l = 0
        r = len(s)-1
        while l < r:
            if s[l] in yuan and s[r] in yuan:
                s[l], s[r] = s[r], s[l]
                l += 1
                r -= 1
            elif s[l] in yuan and s[r] not in yuan:
                r -= 1
            elif s[l] not in yuan and s[r] in yuan:
                l += 1
            else:
                l += 1
                r -= 1
        return ''.join(s) 
        
# @lc code=end

