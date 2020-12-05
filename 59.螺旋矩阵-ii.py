#
# @lc app=leetcode.cn id=59 lang=python3
#
# [59] 螺旋矩阵 II
#

# @lc code=start
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        if not n:
            return []
        if n == 1:
            return [[1]]
        res = [[0 for _ in range(n)] for _ in range(n)]
        # tmp = 1
        flag = 0
        # while tmp < n*n:
        def dfs(i, j, tmp):
            if res[i][j]:
                return
            # visited[i][j] = True
            res[i][j] = tmp
            tmp += 1
            if j + 1 < n and (i-1<0 or res[i-1][j]):
                dfs(i, j+1, tmp)
            flag = 1
            if i + 1 < n:
                dfs(i+1, j, tmp)
            flag = 2
            if j - 1 >= 0:
                dfs(i, j - 1, tmp)
            flag = 3
            if i - 1 >= 0:
                dfs(i-1, j, tmp)
        dfs(0, 0, 1)
        return res
            
# @lc code=end

