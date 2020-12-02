#
# @lc app=leetcode.cn id=213 lang=python3
#
# [213] 打家劫舍 II
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        m = len(nums)
        if m == 1:
            return nums[0]
        return max(self.robfunc(nums[: m-1]), self.robfunc(nums[1: m]))


    def robfunc(self, nums):
        m = len(nums)
        # if not m:
        #     return 0
        if m == 1:
            return nums[0]
        # for i in range(m):
        dp = [0 for _ in range(m)]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, m):
            dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        return dp[-1]


# @lc code=end

