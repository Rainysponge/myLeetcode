#
# @lc app=leetcode.cn id=367 lang=python3
#
# [367] 有效的完全平方数
#

# @lc code=start
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        n = 1
        while num>=0:
            num -= n
            if num == 0:
                return True
            n += 2
        return False
        
# @lc code=end

