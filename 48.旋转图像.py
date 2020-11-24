#
# @lc app=leetcode.cn id=48 lang=python3
#
# [48] 旋转图像
#

# @lc code=start
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        if not matrix:
            return []
        m = len(matrix)
        n = len(matrix[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if visited[i][j]:
                    continue
                else:

                    matrix[i][j], matrix[j][n-i-1], matrix[m-1-i][n-1-j], matrix[m-1-j][i] = matrix[m-1-j][i], matrix[i][j], matrix[j][n-i-1], matrix[m-1-i][n-1-j]
                    visited[i][j], visited[j][n-i-1], visited[m-1-i][n-1-j], visited[m-1-j][i] = True, True, True, True
        return matrix
# @lc code=end

