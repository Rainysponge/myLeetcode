#
# @lc app=leetcode.cn id=172 lang=python3
#
# [172] 阶乘后的零
#

# @lc code=start
class Solution:
    def trailingZeroes(self, n: int) -> int:
        if n < 5:
            return 0
        else:
            return n//5 + self.trailingZeroes(n//5)
        


        
# @lc code=end

