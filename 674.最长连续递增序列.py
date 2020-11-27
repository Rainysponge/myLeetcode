#
# @lc app=leetcode.cn id=674 lang=python3
#
# [674] 最长连续递增序列
#

# @lc code=start
class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        m = len(nums)
        if m == 1:
            return nums[0]
        res = 0
        tmp = 1
        for i in range(m-1):
            if nums[i] < nums[i+1]:
                tmp += 1
            else:
                tmp = 1
            res = max(res, tmp)
        return res
# @lc code=end

