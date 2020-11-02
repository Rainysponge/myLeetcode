#
# @lc app=leetcode.cn id=162 lang=python3
#
# [162] 寻找峰值
#

# @lc code=start
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # 暴力 runtime beats 71.27%笑死我了 O(n)
        m = len(nums)
        # if m == 1:
        #     return 0
        # if nums[0] > nums[1]:
        #     return 0

        # for i in range(1,m-1):
        #     if nums[i] > nums[i-1]:
        #         if nums[i] > nums[i+1]:
        #             return i
        #     else:
        #         return i
        # return m-1
        # 二分法
        
        left = 0
        right = m - 1
        
        while left < right:
            mid = (left+right) // 2
            if nums[mid]>nums[mid+1]:
                right = mid
            else:
                left = mid + 1
        return left



            
# @lc code=end

