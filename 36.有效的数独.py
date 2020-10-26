#
# @lc app=leetcode.cn id=36 lang=python3
#
# [36] 有效的数独
#

# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # # row
        # for i in range(9):
        #     List = []
        #     for j in range(9):
                
        #         if board[i][j] == '.':
        #             continue
        #         if board[i][j] not in List:
        #             List.append(board[i][j])
        #         else:
        #             return False
        # # col
        # for i in range(9):
        #     List = []
        #     for j in range(9):
                
        #         if board[j][i] == '.':
        #             continue
        #         if board[j][i] not in List:
        #             List.append(board[j][i])
        #         else:
        #             return False
        # 9*9
        # for m in range(3):
        #     for i in range(3):
        #         # 9个九宫格
        #         List = []
        #         for j in range(3):
                    
                    
        #             for k in range(3):
        #                 if board[i*3+k][j+3*m] == '.' :
        #                     continue
        #                 if board[i*3+k][j+3*m] not in List:
        #                     List.append(board[i*3+k][j+3*m])
        #                 else:
        #                     return False
        
                       

        # return True
        

        """
        0 1 2     不难看出对于col，0，1，2号九宫格可以看作col//3号
        3 4 5     对于raw，0，3，6号可以看作raw//3 * 3
        6 7 8     对于整个九宫格而言，编号等于行编号加列编号（神奇！）
        由此可得出  编号为(raw//3)*3 + col//3
        """
        # dict_raw = [{}] * 9
        # dict_col = [{}] * 9
        # dict_box = [{}] * 9

        # for raw in range(9):
        #     for col in range(9):
        #         num = board[raw][col]
        #         if num == '.':
        #             continue
        #         if num not in dict_raw[raw] and num not in dict_col[col] and num not in dict_box[(raw//3)*3 + (col//3)]:
        #             dict_raw[raw][num] = 1
        #             dict_col[col][num] = 1
        #             dict_box[3*(raw//3) + (col//3)][num] = 1
        #         else:
        #             return False
        # return True
        dic_row = [{},{},{},{},{},{},{},{},{}]            # 每行的元素以一个字典储存，key是数字，value统一为1.
        dic_col = [{},{},{},{},{},{},{},{},{}]
        dic_box = [{},{},{},{},{},{},{},{},{}]

        for i in range(len(board)):
            for j in range(len(board)):
                num = board[i][j]
                if num == ".":
                    continue
                if num not in dic_row[i] and num not in dic_col[j] and num not in dic_box[3*(i//3)+(j//3)]:
                    dic_row[i][num] = 1
                    dic_col[j][num] = 1
                    dic_box[3*(i//3)+(j//3)][num] = 1       # 利用地板除，向下取余。巧妙地将矩阵划分为九块
                else:
                    return False

        return True
         
# @lc code=end

