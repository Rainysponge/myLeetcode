#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] 单词搜索
#

# @lc code=start
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        if not board:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word):
                    return True
        return False
      
    def dfs(self, board, i, j, word):
        if len(word) == 0:
            return True
        if not 0<=i<len(board) or not 0<=j<len(board[0]) or word[0]!=board[i][j]:
            return False
        tmp, board[i][j] = board[i][j], None
        res = self.dfs(board,i-1,j,word[1:]) or self.dfs(board,i+1,j,word[1:]) or self.dfs(board,i,j-1,word[1:]) or self.dfs(board,i,j+1,word[1:])
        # res = self.dfs(board, i+1, j, word[1:]) or self.dfs(board, i-1, j, word[1:]) or self.dfs(board, i, j-1, word[1:]) or self.dfs(board, i, j+1, word[1:]):
        board[i][j] = tmp
        return res 





# @lc code=end

