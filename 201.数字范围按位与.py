#
# @lc app=leetcode.cn id=201 lang=python3
#
# [201] 数字范围按位与
#

# @lc code=start
class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        count = 0
        while m!=n:
            n>>=1
            m>>=1
            count += 1
        return m<<count
        
# @lc code=end

