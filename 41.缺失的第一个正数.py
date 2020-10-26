#
# @lc app=leetcode.cn id=41 lang=python3
#
# [41] 缺失的第一个正数
#

# @lc code=start
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if nums == []:
            return 1
        anser = [i for i in range(1,len(nums)+1)]
        for i in range(len(nums)):
           if nums[i]>0 and nums[i]<=len(nums) and anser[nums[i]-1] == nums[i]:
                
                anser[nums[i]-1] = len(nums) + 1


        return min(anser)
        
# @lc code=ends

