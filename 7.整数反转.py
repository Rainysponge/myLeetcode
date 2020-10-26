#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            f = 1
            s = str(-x)
        else:
            f = 0
            s = str(x)
        t = ''
        for i in range(len(s)):
            t += s[len(s)-i-1]
            #print(len(s)-i-1)
        if int(t) < -2**31 or int(t)>2**31-1:
            return 0
        elif f == 1:
            c = int(t)
            return(-c)
        else:
            c = int(t)
            return(c)
                    
            
# @lc code=end

