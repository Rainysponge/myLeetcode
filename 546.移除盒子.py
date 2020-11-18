#
# @lc app=leetcode.cn id=546 lang=python3
#
# [546] 移除盒子
#

# @lc code=start
class Solution:
    def removeBoxes(self, boxes: List[int]) -> int:
        n = len(boxes)
        dp = [[[0]*n for _ in range(n)]for _ in range(n)]
        return self.dfs(boxes,dp,0,n-1,0)
    
    def dfs(self,boxes,dp,l,r,k):
        if l > r:
            return 0
        if dp[l][r][k] > 0:
            return dp[l][r][k]
        while l < r and boxes[r] == boxes[r-1]:
            r -= 1
            k += 1
            
        dp[l][r][k] = self.dfs(boxes,dp,l,r-1,0) + (k+1)*(k+1)
        for i in range(l,r):
            if boxes[i] == boxes[r]:
                dp[l][r][k] = max(dp[l][r][k],self.dfs(boxes,dp,l,i,k+1) + self.dfs(boxes,dp,i+1,r-1,0))
        return dp[l][r][k]
# @lc code=end

