#
# @lc app=leetcode.cn id=191 lang=python3
#
# [191] 位1的个数
#

# @lc code=start
class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n >= 0:
            if n % 2:
                res += 1
            n = n // 2
        return res
        
# @lc code=end

