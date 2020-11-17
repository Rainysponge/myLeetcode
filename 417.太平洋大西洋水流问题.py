#
# @lc app=leetcode.cn id=417 lang=python3
#
# [417] 太平洋大西洋水流问题
#

# @lc code=start
class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        def dfs(i, j, string):
            if visited[i][j] == 1:
                return
            visited[i][j] = 1
            if string == "po":
                po[i][j] = 1
            else:
                ao[i][j] = 1
                
            for k in range(4):
                x = i + dx[k]
                y = j + dy[k]
                
                if 0<= x < m and 0 <= y < n and matrix[x][y] >= matrix[i][j]: #可以流到下一个点
                    dfs(x, y, string)



        
        
        if not matrix or not matrix[0]:
            return []
        m = len(matrix)
        n = len(matrix[0])
        i = 0
        res = []
        po = [[0 for _ in range(n)] for _ in range(m)]
        ao = [[0 for _ in range(n)] for _ in range(m)]
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        visited = [[0 for i in range(n)]  for j in range(m)]
        for j in range(n):
            dfs(i, j, "po") #上面的太平洋
            
        visited = [[0 for i in range(n)]  for j in range(m)]    
        i = m - 1
        for j in range(n):
            dfs(i, j, "ao") #下面的大西洋
            
        visited = [[0 for i in range(n)]  for j in range(m)]        
        j = 0
        for i in range(m):
            dfs(i, j, "po") #左边的太平洋
            
        visited = [[0 for i in range(n)]  for j in range(m)]    
        j = n - 1
        for i in range(m):
            dfs(i, j, "ao") #右边的大西洋
            
        res = []
        for i in range(m):
            for j in range(n):
                if po[i][j] and ao[i][j]: #取交集
                    res.append([i, j])
                    
        return res
 
        
# @lc code=end

