#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            x = 1/x
        n = abs(n)
        x0 = x*x
        return self.myPow(x0,n//2) if (n%2==0) else x*self.myPow(x0,n//2)

        


# @lc code=end

