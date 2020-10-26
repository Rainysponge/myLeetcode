#
# @lc app=leetcode.cn id=27 lang=python3
#
# [27] 移除元素
#

# @lc code=start
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        nums_len = len(nums)
        res = nums_len
        j = 0
        for i in range(nums_len):
            
            if nums[j] == val:
                nums.pop(j)
                res -= 1
                j -= 1
            j += 1
            if j == nums_len:
                break
        return res
# @lc code=end

