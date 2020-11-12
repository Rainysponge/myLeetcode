#
# @lc app=leetcode.cn id=287 lang=python3
#
# [287] 寻找重复数
#

# @lc code=start
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # 52/53 Time
        # for i in range(len(nums)-1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] == nums[j]:
        #             return nums[i]
        # 作弊使用哈希表
        # hash_table = {}
        # for i in range(len(nums)):
        #     if nums[i] not in hash_table:
        #         hash_table[nums[i]] = 1
        #     else:
        #         return nums[i]
        left = 0
        right = len(nums) - 1
        while(left <= right):
            mid = left + (right - left)//2
            count = 0
            for i in range(len(nums)):
                if nums[i] <= mid :
                    count += 1
            if count > mid :
                right = mid - 1
            else:
                left = mid + 1
        return left


# @lc code=end

