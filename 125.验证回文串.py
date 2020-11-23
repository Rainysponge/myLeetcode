#
# @lc app=leetcode.cn id=125 lang=python3
#
# [125] 验证回文串
#

# @lc code=start
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # if not s:
        #     return True
        # m = len(s)
        # res = []
        # s = s.lower()
        # for i in range(m):
        #     if s[i].isalnum():
        #         res.append(s[i])
        # return res[::] == res[::-1]
        # s = s[:i]+s[i+1:]
        res = list(filter(str.isalnum, s.lower()))
        return res == res[::-1]
        

            

# @lc code=end

