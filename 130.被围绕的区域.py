#
# @lc app=leetcode.cn id=130 lang=python3
#
# [130] 被围绕的区域
#

# @lc code=start
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return []

        m = len(board)
        n = len(board[0])

        def dfs(board, i, j):
            if not 0<=i<m or not 0<=j<n or board[i][j] != 'O':
                return
            
            board[i][j] = 'M'

            dfs(board, i+1, j)
            dfs(board, i-1, j)
            dfs(board, i, j+1)
            dfs(board, i, j-1)

        






        

        for i in range(m):
            for j in range(n):
                isBorder = i == 0 or j == 0 or j == n-1 or i == m-1
                
                if isBorder and board[i][j] == 'O':
                    dfs(board, i, j)
                


        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                if board[i][j] == "M":
                    board[i][j] = "O"











        
        # def dfs(board, i, j):
        #     # 不处于矩阵内，或者如果已经标记的话，直接跳过
        #     if not (0<=i<m) or not (0<=j<n) or board[i][j] != 'O':
        #         return
            
        #     # 当确认为未标记的，并与边界 'O' 直接间接相连的 'O' 时，标记为 'M'
        #     board[i][j] = 'M'
        #     # 向四个方位扩散
        #     # 上下左右
        #     dfs(board, i-1, j)
        #     dfs(board, i+1, j)
        #     dfs(board, i, j-1)
        #     dfs(board, i, j+1)
            
        
        # if not board or len(board)==0:
        #     return
        
        # m = len(board)
        # n = len(board[0])
        # for i in range(m):
        #     for j in range(n):
        #         is_border = (i==0 or j==0 or i==m-1 or j==n-1)
        #         if is_border and board[i][j] == 'O':
        #             # self.dfs(board, i, j, m, n)
        #             dfs(board, i, j)
        # for i in range(m):
        #     for j in range(n):
        #         if board[i][j] == 'O':
        #             board[i][j] = 'X'
        #         if board[i][j] == 'M':
        #             board[i][j] = 'O'
       

# @lc code=end

