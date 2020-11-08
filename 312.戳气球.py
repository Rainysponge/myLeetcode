#
# @lc app=leetcode.cn id=312 lang=python3
#
# [312] 戳气球
#

# @lc code=start
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
    #     n = len(nums)
    #     nums.insert(0, 1)
    #     nums.append(1)
    #     c = [[0] * (n + 2) for _ in range(n + 2)]
    #     return self.dfs(nums, c, 1, n)
    # def dfs(self, nums, c, i, j):
    #     if i>j:
    #         return 0
    #     if c[i][j] > 0:
    #         return c[i][j]
    #     if i == j:
    #         return nums[i - 1] * nums[i] * nums[i + 1]
    #     res = 0
    #     for k in range(i,j+1):
    #         res = max(res, self.dfs(nums, c, i, k-1)+nums[i-1]*nums[k]*nums[j+1] + self.dfs(nums, c, k+1,j))
    #         c[i][j] = res
    #     return c[i][j]


        n = len(nums)
        nums.insert(0, 1)
        nums.append(1)
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        for len_ in range(1, n + 1):
            for left in range(1, n - len_ + 2):
                right = left + len_ - 1
                for k in range(left, right + 1):
                    dp[left][right] = max(dp[left][right], dp[left][k - 1] + nums[left - 1] * nums[k] * nums[right + 1] + dp[k + 1][right])
        return dp[1][n]
        
# @lc code=end

