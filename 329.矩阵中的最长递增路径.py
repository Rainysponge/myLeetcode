#
# @lc app=leetcode.cn id=329 lang=python3
#
# [329] 矩阵中的最长递增路径
#

# @lc code=start
class Solution:
    # def __init__(self):
    #     self.m = 0
    #     self.n = 0
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
    # 爆栈
    #     self.m = len(matrix)
    #     self.n = len(matrix[0])
    #     res = []
    #     is_used = [[False for _ in range(self.n)] for _ in range(self.m)]
    #     for i in range(self.m):
    #         for j in range(self.n):
    #             self.dfs(matrix, i, j, 0, res, matrix[i][j], is_used)
    #     return res
    # def dfs(self, matrix, i, j, Sum, SumList, t, is_used):
    #     if not (0<=i<self.m) or not (0<=j<self.n):
    #         return
    #     if is_used[i][j]:
    #         return
    #     Sum += matrix[i][j]
        
    #     if matrix[i][j] < t:
    #         SumList.append(Sum)
    #         return
    #     self.dfs(matrix, i-1, j, Sum, SumList, matrix[i][j], is_used)
    #     self.dfs(matrix, i+1, j, Sum, SumList, matrix[i][j], is_used)
    #     self.dfs(matrix, i, j-1, Sum, SumList, matrix[i][j], is_used)
    #     self.dfs(matrix, i, j+1, Sum, SumList, matrix[i][j], is_used)
        
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        
        def dfs(x0, y0):
            if (x0, y0) in dic:
                return dic[(x0, y0)]
            
            sub_res = 0
            for k in range(4):
                x = x0 + dx[k]
                y = y0 + dy[k]
 
                if 0 <= x < m and 0 <= y < n and matrix[x][y] > matrix[x0][y0]:
                    sub_res = max(sub_res, dfs(x, y))
                    
            dic[(x0, y0)] = 1 + sub_res
            return dic[(x0, y0)] 
                
        res = 1
        dic = dict()
        # 这里用字典来表示是否用过类似哈希表
        for i in range(m):
            for j in range(n):
                res = max(res, dfs(i, j))
                
        return res
 
     
# @lc code=end

