#
# @lc app=leetcode.cn id=461 lang=python3
#
# [461] 汉明距离
#

# @lc code=start
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        res = x ^ y
        return bin(res).count('1')
        # return type(bin(res))
        
# @lc code=end

