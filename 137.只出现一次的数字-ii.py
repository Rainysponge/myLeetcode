#
# @lc app=leetcode.cn id=137 lang=python3
#
# [137] 只出现一次的数字 II
#

# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # return (3*sum(set(nums)) - sum(nums)) // 2
        ones, twos = 0, 0
        for num in nums:
            ones = (ones^num) & ~twos
            twos = (twos^num) & ~ones

        return ones





# @lc code=end

