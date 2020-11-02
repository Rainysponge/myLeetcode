#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # hashTable 做不到最佳的空间与时间复杂度，这里采
        # 用摩尔投票法
        count = 0
        res = nums[0]
        
        for i in range(1, len(nums)):
            if res != nums[i]:
                count -= 1
                if count < 0:
                    count = 0
                    res = nums[i]
            else:
                count += 1
        return res
# @lc code=end

