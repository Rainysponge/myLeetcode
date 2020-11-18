#
# @lc app=leetcode.cn id=417 lang=python3
#
# [417] 太平洋大西洋水流问题
#

# @lc code=start
class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        # 逆向搜索，从边界往里面搜索，最后取交集即可！
        if not matrix or not matrix[0]:
            return []
        m = len(matrix)
        n = len(matrix[0])

        To_P = [[0 for _ in range(n)] for _ in range(m)]
        To_A = [[0 for _ in range(n)] for _ in range(m)]
        visited = [[0 for _ in range(n)] for _ in range(m)]
        dx = [1, -1, 0 ,0]
        dy = [0, 0, 1, -1]
        def dfs(i, j, To_ocean):
            if visited[i][j] == 1:
                return
            visited[i][j] = 1
            To_ocean[i][j] = 1
            for k in range(4):
                x = i + dx[k]
                y = j + dy[k]
                if 0<=x<m and 0<=y<n and matrix[x][y] >= matrix[i][j]:
                    dfs(x, y, To_ocean)
          
        visited = [[0 for _ in range(n)] for _ in range(m)]
        # 最上面的太平洋中i==0
        i = 0
        for j in range(n):
            dfs(i, j, To_P)
        # 最左的太平洋j==0
        visited = [[0 for _ in range(n)] for _ in range(m)]
        j = 0
        for i in range(m):
            dfs(i, j, To_P)
        # 最右
        visited = [[0 for _ in range(n)] for _ in range(m)]
        j = n - 1
        for i in range(m):
            dfs(i, j, To_A)
        # 最下
        visited = [[0 for _ in range(n)] for _ in range(m)]
        i = m - 1 
        for j in range(n):
            dfs(i, j, To_A)
        res = []
        for i in range(m):
            for j in range(n):
                if To_A[i][j] and To_P[i][j]:
                    res.append([i,j])
        return res
        
        
        
# @lc code=end

