#
# @lc app=leetcode.cn id=463 lang=python3
#
# [463] 岛屿的周长
#

# @lc code=start
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        count = 0
        repeat = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    count += 1
                    if i - 1 >= 0 and grid[i-1][j] == 1:
                        repeat += 1
                    if i + 1 < m and grid[i+1][j] == 1:
                        repeat += 1
                    if j - 1 >= 0 and grid[i][j-1] == 1:
                        repeat += 1
                    if j + 1 < n and grid[i][j+1] == 1:
                        repeat += 1
        return count * 4 - repeat


# @lc code=end

