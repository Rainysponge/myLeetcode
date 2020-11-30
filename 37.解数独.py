#
# @lc app=leetcode.cn id=37 lang=python3
#
# [37] 解数独
#

# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # row = [{} for _ in range(9)]
        # col = [{} for _ in range(9)]
        def isAvailable(row, col, num):
            if num in board[row]:
                return False
            for i in range(9):
                if num == board[i][col]:
                    return False
            grid = []
            # 检查九宫格
            for i in range(row//3*3, (row//3+1)*3):
                # i为列
                grid += board[i][col//3*3: (col//3+1)*3]
            if num in grid:
                return False
            return True

        #  def isAvailable(pos_row, pos_col, num):
        #     if num in board[pos_row]:
        #         return False
        #     for i in range(9):
        #         if board[i][pos_col] == num:
        #             return False
        #     gird33 = []
        #     for i in range(pos_row//3*3, (pos_row//3+1)*3):
        #         gird33 += board[i][pos_col//3*3:(pos_col//3+1)*3]
        #     if num in gird33:
        #         return False
        #     return True


        def positionTry(row, col):
            if row == 9 and col == 0:
                return True
            if board[row][col] == '.':
                for i in range(1, 10):
                    if isAvailable(row, col, str(i)):
                        board[row][col] = str(i)
                        flag = positionTry(row + (col+1) // 9, (col+1) % 9)
                        # 当col到最底部是ROW+1
                        if not flag:
                            board[row][col] = '.'
                        else:
                            return True
            else:
                # 当有数字时检查下一个位子
                return positionTry(row + (col+1)//9, (col+1)%9)
        positionTry(0,0)
        # return board
       

        # def posTry(pos_row, pos_col):
        #     if pos_row == 9 and pos_col == 0:
        #         return True
        #     if board[pos_row][pos_col] == '.':
        #         for i in range(1, 10):
        #             if isAvailable(pos_row, pos_col, str(i)):
        #                 board[pos_row][pos_col] = str(i)
        #                 flag = posTry(pos_row+(pos_col+1) // 9, (pos_col+1) % 9)
        #                 if not flag:
        #                     board[pos_row][pos_col] = '.'
        #                 else:
        #                     return True
        #     else:
        #         return posTry(pos_row+(pos_col+1) // 9, (pos_col+1) % 9)

        # posTry(0, 0)








# @lc code=end

