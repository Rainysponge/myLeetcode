#
# @lc app=leetcode.cn id=476 lang=python3
#
# [476] 数字的补数
#

# @lc code=start
class Solution:
    def findComplement(self, num: int) -> int:
        count = 0
        if num == 1:
            return 0
        while 2**count <= num :
            count += 1
        return 2**count - 1 - num 
# @lc code=end

