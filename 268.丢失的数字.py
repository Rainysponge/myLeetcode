#
# @lc app=leetcode.cn id=268 lang=python3
#
# [268] 丢失的数字
#

# @lc code=start
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i in range(len(nums)):
            res ^= i^nums[i]
        return res
        # return (len(nums)+1)*len(nums)//2 - sum(nums)
        # n = len(nums)
        # return n * (n + 1) //2 - sum(nums)
# @lc code=end

