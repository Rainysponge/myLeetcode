#
# @lc app=leetcode.cn id=529 lang=python3
#
# [529] 扫雷游戏
#

# @lc code=start
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        # (row, col), directions = click, ((-1, 0), (1, 0), (0, 1), (0, -1), (-1, 1), (-1, -1), (1, 1), (1, -1))
        # if 0 <= row < len(board) and 0 <= col < len(board[0]):
        #     if board[row][col] == 'M':
        #         board[row][col] = 'X'
        #     elif board[row][col] == 'E':
        #         n = sum([board[row + r][col + c] == 'M' for r, c in directions if 0 <= row + r < len(board) and 0 <= col +c < len(board[0])])
        #         board[row][col] = str(n if n else 'B')
        #         if not n:
        #             for r, c in directions:
        #                 self.updateBoard(board, [row + r, col + c])
        # return board

        # 个人感觉BFS更好理解

        m,n=len(board),len(board[0])
        i,j=click[0],click[1]
        if board[i][j] == "M":
            board[i][j] = "X"
        directions = [(-1,-1), (0,-1), (1,-1), (1,0), (1,1), (0,1), (-1,1), (-1,0)]
        import collections
        q = collections.deque()
        q.append(click)
        visited = set(click)
        
        def numBombs(board,i,j):
            # 判断地雷数目
            mine_count = 0
            for d in directions:
                ni, nj = i + d[0], j + d[1]
                if 0<=ni<m and 0<=nj<n and board[ni][nj] == 'M':
                    mine_count+=1
            return mine_count
        while q:
            for _ in range(len(q)):
                x,y=q.popleft()
                if board[x][y] == 'E':
                    bombsNextTo = numBombs(board,x,y)
                    board[x][y] = "B" if bombsNextTo == 0 else str(bombsNextTo)
                    if bombsNextTo == 0:
                        for d in directions:
                            ni, nj = x + d[0], y + d[1]
                            if 0<=ni<m and 0<=nj<n and (ni,nj) not in visited:
                                q.append((ni,nj))
                                visited.add((ni,nj))
        return board
# @lc code=end

