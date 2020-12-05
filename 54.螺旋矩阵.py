#
# @lc app=leetcode.cn id=54 lang=python3
#
# [54] 螺旋矩阵
#

# @lc code=start
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # if not matrix or not matrix[0]:
        #     return []
        # m = len(matrix)
        # n = len(matrix[0])
        # # flag = 0
        # # 0 left 1 down 2 right 3 up
        # visited = [[False for _ in range(n)]for _ in range(m)]
        # res = []
        # def dfs(i, j):
        #     if visited[i][j]:
        #         return
        #     visited[i][j] = True
        #     res.append(matrix[i][j])
            
        #     if j + 1 < n and (i-1<0 or visited[i-1][j]):
        #         dfs(i, j+1)
        #     flag = 1
        #     if i + 1 < m:
        #         dfs(i+1, j)
        #     flag = 2
        #     if j - 1 >= 0:
        #         dfs(i, j - 1)
        #     flag = 3
        #     if i - 1 >= 0:
        #         dfs(i-1, j)
            
            
        # dfs(0, 0)
        # return res
        if not matrix or not matrix[0]: return []
        M, N = len(matrix), len(matrix[0])
        left, right, up, down = 0, N - 1, 0, M - 1
        res = []
        x, y = 0, 0
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cur_d = 0
        while len(res) != M * N:
            res.append(matrix[x][y])
            if cur_d == 0 and y == right:
                cur_d += 1
                up += 1
            elif cur_d == 1 and x == down:
                cur_d += 1
                right -= 1
            elif cur_d == 2 and y == left:
                cur_d += 1
                down -= 1
            elif cur_d == 3 and x == up:
                cur_d += 1
                left += 1
            cur_d %= 4
            x += dirs[cur_d][0]
            y += dirs[cur_d][1]
        return res

# @lc code=end

