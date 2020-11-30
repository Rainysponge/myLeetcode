#
# @lc app=leetcode.cn id=52 lang=python3
#
# [52] N皇后 II
#

# @lc code=start
class Solution:
    def totalNQueens(self, n: int) -> int:
        board = [['.'] * n for _ in range(n)]
        res = []
        self.dfs(board, n, 0, res)
        return len(res)

    def isAvailable(self, row, col, n, board):
        for i in range(1, row + 1):
            # 检查列
            if board[row-i][col] == 'Q':
                return False
            # 检查主对角线
            if col - i >= 0 and board[row-i][col-i] == 'Q':
                return False
            # 检查副对角线
            if col + i < n and board[row-i][col+i] == 'Q':
                return False
        return True



    def dfs(self, board, n, row, res):
        if row == n:
            res.append([''.join(i) for i in board])
            return
        for i in range(n):
            if self.isAvailable(row, i, n, board):
                board[row][i] = 'Q'
                self.dfs(board, n, row + 1, res)
                board[row][i] = '.'
# @lc code=end

