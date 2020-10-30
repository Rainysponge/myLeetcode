#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子数组
#

# @lc code=start
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        m = len(nums)

        dp = [[nums[0], nums[0]]for _ in range(m)]
        res = nums[0]
        for i in range(1, m):
            if nums[i] >= 0:
                dp[i][0] = max(dp[i-1][0]*nums[i], nums[i])  # 除0
                dp[i][1] = min(dp[i-1][1]*nums[i], nums[i])
            else:
                dp[i][0] = max(dp[i-1][1]*nums[i], nums[i])
                dp[i][1] = min(dp[i-1][0]*nums[i], nums[i])
            if dp[i][0] > res:
                res = dp[i][0]
        return res
# @lc code=end

