#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums_len = len(nums)
        result = nums[:]
        for i in range(nums_len):
            nums[(i+k)%nums_len] = result[i]
        
# @lc code=end

