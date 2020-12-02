#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        # if not nums:
        #     return 0

        # m = len(nums)
        # if m == 1:
        #     return nums[0]
        # dp = [0 for _ in range(m)]
        # dp[0] = nums[0]
        # dp[1] = max(nums[0], nums[1])
        # for i in range(2,m):
        #     dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        # return dp[-1]
        if not nums:
            return 0
        m = len(nums)
        if m == 1:
            return nums[0]
        dp = [0 for _ in range(m) ]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, m):
            dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        return dp[-1]



# @lc code=end

