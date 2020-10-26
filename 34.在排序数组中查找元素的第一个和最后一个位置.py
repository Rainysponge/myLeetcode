#
# @lc app=leetcode.cn id=34 lang=python3
#
# [34] 在排序数组中查找元素的第一个和最后一个位置
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # def left_find(nums, target):
        #     left,right = 0, len(nums) - 1
        #     while left<right:
        #         mid = left + (right-left)//2
        #         if nums[mid]>target or nums[mid]==target:
        #             right = mid
        #         else:
        #             left  = mid + 1
        #     return left if nums and nums[left]==target else -1
        
        # def right_find(nums, target):
        #     left,right = 0, len(nums)-1
        #     while left<right:
        #         mid = left + (right - left)//2 + 1
        #         if nums[mid]<target or nums[mid]==target:
        #             low = mid
        #         else:
        #             right = mid - 1
        #     return right if nums and nums[right]==target else -1
        
        # return [left_find(nums,target),right_find(nums,target)]


        def find_left_index(nums, target):
            low, high = 0, len(nums) - 1
            while low < high:
                mid = low + (high - low) // 2
                if nums[mid] > target or target == nums[mid]:
                    high = mid
                else:
                    low = mid + 1
            return low if nums and nums[low] == target else -1

        # 使用二分法找到target在nums中最后一次出现的位置
        def find_right_index(nums, target):
            low, high = 0, len(nums) - 1
            while low < high:
                mid = low + (high - low) // 2 + 1
                if nums[mid] < target or target == nums[mid]:
                    low = mid
                else:
                    high = mid - 1
            return low if nums and nums[low] == target else -1

        return [find_left_index(nums, target), find_right_index(nums, target)]


# @lc code=end

