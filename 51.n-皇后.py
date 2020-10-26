#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N 皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        grid = [['.']*n for i in range(n)]
        queen = set()
        output = []  # 输出

        # self.queenDFS(grid, 0, n, queen, output)
        # return output

        def isQueenLegel(self,grid,row,col):

            for i in range(row):
                if grid[i][col] == 'Q':
                    return False
                x = row - 1
                y = col - 1

                while x >= 0 and y >= 0:
                    if grid[x][y]  == 'Q':
                        return False
                    x -= 1
                    y -= 1

                x = row - 1
                y = col + 1

                while x>= 0 and y<len(grid[0]):
                    if grid[x][y] == 'Q':
                        return False
                    x -= 1
                    y += 1

                return True

        def queenDFS(self,grid,index,n,queen,output):
            if index == n:
                solution = []
                for _,col in sorted(queen):
                    solution.append('.'*col + 'Q' + '.'*(n-col-1))

                output.append(solution)

                for i in range(n):
                    if(self.isQueenLegel(grid,index,i)):
                        queen.add((index,i))
                        grid[index][i] = 'Q'

                        self.queenDFS(grid, index+1,n,queen,output)
                        grid[index][i] = '.'
                        queen.remove((index,i))

        self.queenDFS(grid, 0, n, queen, output)
        return output


# @lc code=end

