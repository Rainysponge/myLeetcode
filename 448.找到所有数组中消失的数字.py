#
# @lc app=leetcode.cn id=448 lang=python3
#
# [448] 找到所有数组中消失的数字
#

# @lc code=start
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # List = [0 for i in range(len(nums))]
        # res = []
        # for i in range(len(nums)):
        #     List[nums[i]-1] = nums[i]
        # for i in range(len(nums)):
        #     if List[i]  == 0:
        #         res.append(i+1)
        #     # else:
                
        # return res
        i = 0
        while i < len(nums):
            if nums[i] != nums[nums[i] - 1]:
                nums[nums[i]-1],nums[i] = nums[i],nums[nums[i]-1]
            else:
                i += 1

        res = []
        for i in  range(len(nums)):
            if i + 1 != nums[i]:
                res.append(i+1)
        return res
        
# @lc code=end

