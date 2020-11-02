#
# @lc app=leetcode.cn id=154 lang=python3
#
# [154] 寻找旋转排序数组中的最小值 II
#

# @lc code=start
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        for i in range(1, len(nums)):
            if nums[i-1]>nums[i]:
                return nums[i]
            if i == len(nums) - 1:
                return nums[0]
# @lc code=end

