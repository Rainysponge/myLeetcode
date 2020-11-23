#
# @lc app=leetcode.cn id=326 lang=python3
#
# [326] 3的幂
#

# @lc code=start
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        if n == 1:
            return True
        
        while n > 0:
            if n == 3:
                return True
            tmp = n // 3
            if tmp * 3 != n or n < 3:
                return False
            n = tmp
            
# @lc code=end

