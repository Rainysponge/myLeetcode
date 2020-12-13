#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_table = {}
        for i in range(len(nums)):
            tmp = target - nums[i]
            if nums[i] in hash_table:
                return [hash_table[nums[i]], i]
            else:
                hash_table[tmp] = i
# @lc code=end

