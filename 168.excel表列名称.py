#
# @lc app=leetcode.cn id=168 lang=python3
#
# [168] Excel表列名称
#

# @lc code=start
class Solution:
    def convertToTitle(self, n: int) -> str:
        res = ''
        
        while n > 0:
            tmp = n % 26
            
            if tmp == 0:
                res = 'Z' + res
                n = n // 27
            else:
                n = n // 26
                res = chr(tmp + 64) + res
        return res

# @lc code=end

