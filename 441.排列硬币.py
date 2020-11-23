#
# @lc app=leetcode.cn id=441 lang=python3
#
# [441] 排列硬币
#

# @lc code=start
class Solution:
    def arrangeCoins(self, n: int) -> int:
        # i = 1
        # res = 0
        # while n >= 0:
        #     n -= i
        #     if n < 0:
        #         return res
        #     res += 1
        #     i += 1
        low = 0
        high = n
        while low <= high:
            mid = int((low + high) / 2)
            if 0 <= n - (mid+1)*mid/2 < mid + 1:
                return mid
            elif n - (mid+1)*mid/2 >= mid + 1:
                low = mid + 1
            elif n - (mid+1)*mid/2 < 0:
                high = mid - 1
        
# @lc code=end

