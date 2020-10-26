#
# @lc app=leetcode.cn id=6 lang=python3
#
# [6] Z 字形变换
#

# @lc code=start
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        s_len = len(s)
        result = ''
        for i in range(numRows+1):
            t = i
            while t<s_len:
                result += s[t]
                t += 1+numRows 
        return result
# @lc code=end

