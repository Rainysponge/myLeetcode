#
# @lc app=leetcode.cn id=69 lang=python3
#
# [69] x 的平方根
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        # 二分查找
        if x in [1,2,3]:
            return 1
        if x == 0:
            return 0
        start = 1
        end = x
        while start <= end:
            res = (start + end + 1)//2
            
            if res**2 <= x < (res+1)**2:
                return res
            if res**2 < x:
                start = res
            else:
                end = res
        

# @lc code=end

