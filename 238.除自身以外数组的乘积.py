#
# @lc app=leetcode.cn id=238 lang=python3
#
# [238] 除自身以外数组的乘积
#

# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = []
        res.append(1)
        temp = 1
        for i in range(0, len(nums)-1):
            temp = temp * nums[i] 
            res.append(temp)
        temp = 1
        for i in range(len(nums)-2, -1, -1):
            temp = temp * nums[i+1]
            res[i] = res[i] * temp
        return res
# @lc code=end

