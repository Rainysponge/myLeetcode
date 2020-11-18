#
# @lc app=leetcode.cn id=486 lang=python3
#
# [486] 预测赢家
#

# @lc code=start
class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        # https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
        dp = [[0 for _ in range(len(nums))] for _ in range(len(nums))]
        dp[0][0] = 0
        for i in range(1, len(nums)):
            dp[i][i] = nums[i]
        for i in range(len(nums)-1, -1, -1):
            for j in range(i+1, len(nums)):
                dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
        return dp[0][len(nums)-1]>=0

        
# @lc code=end

