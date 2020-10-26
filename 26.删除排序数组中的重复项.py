#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        nums_len = len(nums)
        index = 0
        for i in range(nums_len):
            if nums[index] == nums[i]:
                continue
            else:
                index += 1
                nums[index] = nums[i]

        return index + 1


# @lc code=end

