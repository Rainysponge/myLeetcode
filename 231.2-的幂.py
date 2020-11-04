#
# @lc app=leetcode.cn id=231 lang=python3
#
# [231] 2的幂
#

# @lc code=start
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # if n == 1:
        #     return True
        if n <= 0 :
            return False
        # if n % 2 == 0:
        #     return self.isPowerOfTwo(n//2)
        # return False
        # 位运算
        while n > 1:
            if n&1 == 1:
                return False
            n = n >> 1
        return True
# @lc code=end

