#
# @lc app=leetcode.cn id=342 lang=python3
#
# [342] 4的幂
#

# @lc code=start
class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        temp = n & (n - 1)
        # 主要是要看num的奇数位上是否有1
        if(n > 0 and temp == 0 and n & 0x55555555) != 0:
            return True
        else:
            return False
# @lc code=end

