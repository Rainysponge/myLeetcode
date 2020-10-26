#
# @lc app=leetcode.cn id=35 lang=python3
#
# [35] 搜索插入位置
#

# @lc code=start
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # left = 0
        # right = len(nums) - 1
        # while left < right:
        #     mid = (left + right)//2
        #     if nums[mid]>target:
        #         end = mid - 1
        #     elif:
        #         nums[mid]<target:
        #         left = mid + 1
        #     else:
        #         return mid

        # return start if left == right else -1
        for i,num in enumerate(nums):#没超过列表边界
            if target<=num:
                return i
        return len(nums)#若超出

        
# @lc code=end

