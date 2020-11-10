#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
    
        res = 0
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    self.dfs(grid,i,j)
        return res
    def dfs(self,grid,i,j):
        grid[i][j] = '0'
        if i-1>=0 and grid[i-1][j]=='1':
            self.dfs(grid,i-1,j)
        if i+1<len(grid) and grid[i+1][j]=='1':
            self.dfs(grid,i+1,j)
        if j-1>=0 and grid[i][j-1]=='1':
            self.dfs(grid,i,j-1)
        if j+1<len(grid[0]) and grid[i][j+1]=='1':
            self.dfs(grid,i,j+1)
        
        
# @lc code=end

