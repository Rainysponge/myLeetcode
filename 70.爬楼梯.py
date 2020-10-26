#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        f = [1,2]
        if n>=3:
            for i in range(2,n):
                tmp = f[i-1] + f[i-2]
                f.append(tmp)
            return f[-1]
        else:
            return f[n-1]
# @lc code=end

