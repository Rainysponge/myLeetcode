#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_hash = {}
        t = len(nums)
        l = range(t)
        for i in l:
            delta = target - nums[i]
            if delta in nums_hash:
                return [nums_hash[delta],i]
            nums_hash[nums[i]] = i
        return []
# @lc code=end

