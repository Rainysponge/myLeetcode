#
# @lc app=leetcode.cn id=202 lang=python3
#
# [202] 快乐数
#

# @lc code=start
class Solution:
    def isHappy(self, n: int) -> bool:
        def func1(n):
            tmp = 0
            while n>0:
                tmp += (n%10)**2
                n = n // 10
            return tmp
        
        if not n:
            return False
        
        t = func1(n)

        dp = {}
        
        while True:
            
            if n == 1:
                return True
            if n in dp:
                return False
            
            dp[n] = 1
            n = func1(n)
        

        
        
# @lc code=end

