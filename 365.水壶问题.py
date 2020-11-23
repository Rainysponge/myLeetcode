#
# @lc app=leetcode.cn id=365 lang=python3
#
# [365] 水壶问题
#

# @lc code=start
class Solution:
    def canMeasureWater(self, x: int, y: int, z: int) -> bool:
        return z == 0 or (x + y >= z and z % self.gcd(x, y) == 0)
        
    def gcd(self, x, y):
        return x if y == 0 else self.gcd(y, x % y)
# @lc code=end

