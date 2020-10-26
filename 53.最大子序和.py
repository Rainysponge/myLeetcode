#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        Sum = 0
        Max = nums[0]
        if len(nums) == 1:
            return nums[0]
        for i in range(len(nums)):
            
            Sum += nums[i]
            if Sum>Max :
                Max = Sum
            if Sum < 0:
                Sum = 0
        return Max
# @lc code=end

