#
# @lc app=leetcode.cn id=179 lang=python3
#
# [179] 最大数
#

# @lc code=start
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums = list(map(str, nums))
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                # eg 3和30,330 > 303所以不用换位置
                if int(nums[i]+nums[j]) <= int(nums[j]+nums[i]):
                    nums[i], nums[j] = nums[j], nums[i]
        # 处理前置的0
        
        while nums and nums[0] == '0':
            nums.pop(0)
        return "".join(nums) if nums else '0'
# @lc code=end

